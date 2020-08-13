/***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
***/
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.*;
import java.util.*;

public class Root {
	
	
    public static void main(String[] args) throws Exception {
		
        String inputFile = null;
        ArrayList<String> nowPML = new ArrayList<String>();
		HashMap<String,Integer> fromLinesPML = new HashMap<String,Integer>(); 
		HashMap<String,Integer> toLinesPML = new HashMap<String,Integer>(); 		
		
		try {
			if ( args.length>0 ) inputFile = args[0];
        	InputStream is = System.in;
        	if ( inputFile!=null ) is = new FileInputStream(inputFile);
        	ANTLRInputStream input = new ANTLRInputStream(is);
			
			long toCompileTime = 0; 
			
        	PromelaLexer lexer = new PromelaLexer(input);
        	CommonTokenStream tokens = new CommonTokenStream(lexer);
        	PromelaParser parser = new PromelaParser(tokens);
        	ParseTree tree = parser.spec(); // parse
			String name1 = "root.pml";	
			String name2 = "brute.pml";
				
			PrintWriter printWriter1 = new PrintWriter(new FileWriter(name1));
			PrintWriter printWriter2 = new PrintWriter(new FileWriter(name2));
			
        	AbstractionVisitor loader = new AbstractionVisitor(parser,printWriter1,printWriter2,inputFile);
			
        	loader.visit(tree);
			printWriter1.flush(); printWriter1.close();
			printWriter2.flush(); printWriter2.close();
			nowPML.add(name1); 
			fromLinesPML.put(name1,new Integer(loader.lineFrom)); 
			toLinesPML.put(name1,new Integer(loader.lineTo));
			
			System.out.println("1. ARP for sketching \n"); 
			long nanoTime0 = System.nanoTime();
			int iter = 1; 
			boolean end = false; 
			while (!nowPML.isEmpty()) {
				String current = nowPML.remove(0); 
				int currentLineFrom = fromLinesPML.get(current).intValue(); 
				int currentLineTo = toLinesPML.get(current).intValue(); 

				System.out.println("Reg Exp is "+loader.regExp);
				System.out.println("\n ITERATION "+(iter-1)+": Process " + current); 
				
                Runtime.getRuntime().exec("spin -a " + current).waitFor();
				long nanoTimeCbefore = System.nanoTime();
                Runtime.getRuntime().exec("gcc -o pan pan.c").waitFor();
				toCompileTime += (System.nanoTime() - nanoTimeCbefore);
                Process exec = Runtime.getRuntime().exec("./pan");
                exec.waitFor();
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                Vector<Integer> e = new Vector<Integer>();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    if (line.startsWith("State-vector")) {
                        final int int1 = Integer.parseInt(String.valueOf(line.substring(line.indexOf("errors:")).charAt(8)));
                        if (int1 == 0) {
                            System.out.println(" There are NO errors \n Solutions are: ");
                            final HashSet<String> e2 = new HashSet<String>();
                            String substring;
                            int index;
							end = true; 
							BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(current)));
							int i = 1;
            				String line1;
            				while ((line1 = bufferedReader2.readLine()) != null) {
								if ((i>=currentLineFrom) && (i<=currentLineTo)) System.out.println(line1); 
								++i;
            				}
                        }
                        else {
                            System.out.println(" There are ERRORS ");
                            Process exec2 = Runtime.getRuntime().exec("spin -t -p " + current);
                            exec2.waitFor();
                            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(exec2.getInputStream()));
                            System.out.println("Error trace: ");
                            String line2;
							Integer value=0; 
                            while ((line2 = bufferedReader2.readLine()) != null) {
                                String trim = line2.trim();
                                if (trim.startsWith("spin: " + current)) {
                                    break;
                                }
                                if (!trim.matches("[0-9]+:(.*)")) {
                                    continue;
                                }
                                final int index2 = trim.indexOf(".pml");
                                if (index2 == -1) {
                                    continue;
                                }
								//System.out.println(trim + " index2+5 " + (index2 + 5)+" index "+trim.indexOf("(state"));
                                String trim2 = trim.substring(index2 + 5, trim.indexOf("(state") - 1).trim();
								String stm = trim.substring(trim.indexOf('[')+1,trim.lastIndexOf(']')); 
                                //System.out.println(trim + " num " + trim2+" stm "+stm);
								System.out.println(stm+" matches regexp "+loader.regExp+" is "+stm.matches(loader.regExp));
								System.out.println(stm+" matches regexp "+loader.regExpSecond+" is "+stm.matches(loader.regExpSecond));
								if (stm.matches(loader.regExp) || stm.matches(loader.regExpSecond)) {
									System.out.println("INN line from "+currentLineFrom+" line to "+currentLineTo+" current line "+trim2+" jump "+loader.lineJump);
									value = Integer.valueOf(trim2); 									
									
									BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(new FileInputStream(current)));
									
					/*				if (loader.numberHoles==2) {
										
										String nameIt1 = "iter"+iter+"1.pml"; // this is the first file 
										PrintWriter printWriterIt1 = new PrintWriter(new FileWriter(nameIt1));
										if (currentLineFrom<value && currentLineFrom2<value2) {
											nowPML.add(nameIt1); 
											fromLinesPML.put(nameIt1,new Integer(currentLineFrom)); 
											toLinesPML.put(nameIt1,new Integer(value-1)); 
											fromLinesPML2.put(nameIt1,new Integer(currentLineFrom2)); 
											toLinesPML2.put(nameIt1,new Integer(value2-1)); 											
										}									
									
										String nameIt2 = "iter"+iter+"2.pml"; // this is the second file 
										PrintWriter printWriterIt2 = new PrintWriter(new FileWriter(nameIt2));
										if (value<currentLineTo) {
											nowPML.add(nameIt2); 
											fromLinesPML.put(nameIt2,new Integer(currentLineFrom)); 
											toLinesPML.put(nameIt2,new Integer(currentLineTo-loader.lineJump)); 			
											fromLinesPML2.put(nameIt2,new Integer(currentLineFrom2-loader.lineJump)); 
											toLinesPML2.put(nameIt2,new Integer(currentLineTo2-loader.lineJump)); 											
										}

										String nameIt3 = "iter"+iter+"3.pml"; // this is the first file 
										PrintWriter printWriterIt3 = new PrintWriter(new FileWriter(nameIt3));
										if (value2<currentLineTo2) {
											nowPML.add(nameIt3); 
											fromLinesPML.put(nameIt3,new Integer(currentLineFrom)); 
											toLinesPML.put(nameIt3,new Integer(currentLineTo)); 
											fromLinesPML2.put(nameIt3,new Integer(currentLineFrom2)); 
											toLinesPML2.put(nameIt3,new Integer(currentLineTo2-loader.lineJump2)); 												
										}									
									
										String nameIt4 = "iter"+iter+"4.pml"; // this is the second file 
										PrintWriter printWriterIt4 = new PrintWriter(new FileWriter(nameIt4));
										if (value<currentLineTo && value2<currentLineTo2) {
											nowPML.add(nameIt4); 
											fromLinesPML.put(nameIt4,new Integer(currentLineFrom)); 
											toLinesPML.put(nameIt4,new Integer(currentLineTo-loader.lineJump)); 			
											fromLinesPML2.put(nameIt4,new Integer(currentLineFrom2-loader.lineJump)); 
											toLinesPML2.put(nameIt4,new Integer(currentLineTo2-loader.lineJump2-loader.lineJump)); 											
										}										
										
										int i = 1;
            							String line1;
            							while ((line1 = bufferedReader1.readLine()) != null) {
                							//System.out.println("check currentLineFrom "+currentLineFrom+" value "+value+" currentLineFrom2 "+currentLineFrom2+" value2 "+value2+" i "+i);
											if (currentLineFrom<value && currentLineFrom2<value2) if (((i<value) || (i>currentLineTo)) && ((i<value2) || (i>currentLineTo2))) printWriterIt1.println(line1); 
											if (value<currentLineTo) if (((i<currentLineFrom) || (i>=value+loader.lineJump)) ) printWriterIt2.println(line1); 
											if (value2<currentLineTo2) if (((i<currentLineFrom2) || (i>=value2+loader.lineJump2)) ) printWriterIt3.println(line1); 
											if (value<currentLineTo && value2<currentLineTo2) if (((i<currentLineFrom) || (i>=value+loader.lineJump)) && ((i<currentLineFrom2) || (i>=value2+loader.lineJump2))) printWriterIt4.println(line1); 
											++i;
            							}
            							bufferedReader1.close();
										printWriterIt1.flush(); printWriterIt1.close();
										printWriterIt2.flush(); printWriterIt2.close();
										printWriterIt3.flush(); printWriterIt3.close();
										printWriterIt4.flush(); printWriterIt4.close();										
										break;  									
									}			*/
									
									String nameIt1 = "iter"+iter+"1.pml"; // this is the first file 
									PrintWriter printWriterIt1 = new PrintWriter(new FileWriter(nameIt1));
									if (currentLineFrom<value) {
										nowPML.add(nameIt1); 
										fromLinesPML.put(nameIt1,new Integer(currentLineFrom)); 
										toLinesPML.put(nameIt1,new Integer(value-1)); 
									}									
									
									String nameIt2 = "iter"+iter+"2.pml"; // this is the second file 
									PrintWriter printWriterIt2 = new PrintWriter(new FileWriter(nameIt2));
									if (value<currentLineTo) {
										nowPML.add(nameIt2); 
										fromLinesPML.put(nameIt2,new Integer(currentLineFrom)); 
										toLinesPML.put(nameIt2,new Integer(currentLineTo-loader.lineJump)); 							
									}
									
									int i = 1;
            						String line1;
            						while ((line1 = bufferedReader1.readLine()) != null) {
                						//String trim = line.trim();
										if (currentLineFrom<value) if ((i<value) || (i>currentLineTo)) printWriterIt1.println(line1); 
										if (value<currentLineTo) if ((i<currentLineFrom) || (i>=value+loader.lineJump)) printWriterIt2.println(line1); 
										++i;
            						}
            						bufferedReader1.close();
									printWriterIt1.flush(); printWriterIt1.close();
									printWriterIt2.flush(); printWriterIt2.close();
									break;  
								}
                                
                            }				
						}
						break; 
					}
				}
				iter++; 
				if (end) break; 
				//if (iter>1) break;
			}
			long nanoTime1 = System.nanoTime();
            long totalARP = (nanoTime1 - nanoTime0) / 1000000L;
			long withoutCompileARP = (nanoTime1 - nanoTime0 - toCompileTime) / 1000000L;
            System.out.println("Total Time ARP " + totalARP + " milis");
			System.out.println("WithoutCompile Time ARP " + withoutCompileARP + " milis \n");
			
			
			nanoTime0 = System.nanoTime();
			toCompileTime = 0; 
			System.out.println("2. Brute-Force for sketching \n");
			String current = name2; 
            Runtime.getRuntime().exec("spin -a " + current).waitFor();
			long nanoTimeCbefore = System.nanoTime();
            Runtime.getRuntime().exec("gcc -o pan pan.c").waitFor();
			toCompileTime += (System.nanoTime() - nanoTimeCbefore);
            Process exec = Runtime.getRuntime().exec("./pan");
            exec.waitFor();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
            	if (line.startsWith("State-vector")) {
                        final int int1 = Integer.parseInt(String.valueOf(line.substring(line.indexOf("errors:")).charAt(8)));
                        if (int1 == 0) {
                            System.out.println(" There are NO errors \n Solutions are: ??="+AbstractionVisitor.currDown);
                        }
                        else {
                            System.out.println(" There are ERRORS for "+AbstractionVisitor.currDown);
						}
				}
        	}
			int k=AbstractionVisitor.currDown+1;
			current = name2; 
			while (k<=AbstractionVisitor.currUp) {
				BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(current)));
									
				String nameIt = "brute"+k+".pml"; // this is the first file 
				PrintWriter printWriterIt = new PrintWriter(new FileWriter(nameIt));

				int i = 1;
            	String line2;
            	while ((line2 = bufferedReader2.readLine()) != null) {
					//System.out.println("lineFrom " + loader.lineFrom + " jump "+loader.lineJump);
               		if ((i<(loader.lineFrom-1)) || (i>=(loader.lineFrom-1+loader.lineJump))) printWriterIt.println(line2); 
					if (i==(loader.lineFrom-1)) {
						String exprOld = loader.exprWithHole; 
						String exprNew = exprOld.replace("?"+loader.currFeat,String.valueOf(k));
						printWriterIt.println("\t "+exprNew);
					}
					++i;
            	}
            	bufferedReader2.close();
				printWriterIt.flush(); printWriterIt.close();				
				
				
            	Runtime.getRuntime().exec("spin -a " + nameIt).waitFor();
				nanoTimeCbefore = System.nanoTime();
            	Runtime.getRuntime().exec("gcc -o pan pan.c").waitFor();
				toCompileTime += (System.nanoTime() - nanoTimeCbefore);
            	exec = Runtime.getRuntime().exec("./pan");
            	exec.waitFor();
				bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            	while ((line = bufferedReader.readLine()) != null) {
            		if (line.startsWith("State-vector")) {
                        final int int1 = Integer.parseInt(String.valueOf(line.substring(line.indexOf("errors:")).charAt(8)));
                        if (int1 == 0) {
                            System.out.println(" There are NO errors \n Solutions are: ??="+k);
                        }
                        else {
                            System.out.println(" There are ERRORS for "+k);
						}
					}
        		}				
				
				
				k++;
			}
			
			nanoTime1 = System.nanoTime();
            long totalBrute = (nanoTime1 - nanoTime0) / 1000000L;
			long withoutCompileBrute = (nanoTime1 - nanoTime0 - toCompileTime) / 1000000L;
            System.out.println("Total Time Brute " + totalBrute + " milis");
			System.out.println("WithoutCompile Time Brute " + withoutCompileBrute + " milis");			
						
		}	
        catch (IOException ex) {
            ex.printStackTrace();
        }
	}
}
