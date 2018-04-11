import java.io.*;
import java.util.*;

/*
//not support recursive url checking.
//For one file:
//1. finish check or not
//2. create a log file include:
//2a. the first error log
//2b. all warning before the first error or before the end
*/

public class Q14_htmlChecker {
    public boolean checkGrammar(String url) {
        //record how many tag that file already used and prepar for the order later.
        Map<String, Integer> tagMap = new HashMap<>();
        Deque<String> tagStack = new LinkedList<>();
        List<String> fileText = readFile(url);
        //tranversive
        //error rule:
        //1. some '<' not finish with '>'
        //2. some '<a>' not finish with '</a>'
        //warning rule:
        //1. lack of <html> and <body>
        //2. lower letter. e.g.<SECTION> with </section>

        int rowCounter = 0;
        int indexCounter = 0;
        boolean warningFlag = false;
        boolean errorFlag = false;
        boolean slashFlag = false;

        int bracketFlag = 0;
        while(rowCounter != fileText.size()) {
            String line = fileText.get(rowCounter);
            indexCounter = 0;
            while(indexCounter != line.length()) {
                if(line.charAt(indexCounter) == '<') {
                    bracketFlag++;
                    //get tag of it
                    StringBuilder sb = new StringBuilder();
                    while(indexCounter != line.length() && line.charAt(indexCounter) != ' ' && line.charAt(indexCounter) != '>') {
                        sb.append(line.charAt(indexCounter));
                        indexCounter++;
                    }
                    //solve tag
                    if(indexCounter + 1 == line.length()) {
                        //SYNTAX ERROR: only have '<'
                        errorFlag = true;
                        break;

                    } else if (line.charAt(indexCounter + 1) == '/') {
                        slashFlag = true;
                        indexCounter++;
                    }
                    String tag = sb.toString();
                    if(slashFlag) {
                        //tagStack
                        //equals() need to override at here
                        // to solve lower letter"section" and mixture"Section" (give a warning)
                        if (tagStack.isEmpty()) {
                            //SYNTAX ERROR: never use this tag
                            errorFlag = true;
                            break;
                        }
                        if (tag.equals(tagStack.peekLast())) {
                            tagStack.pollLast();
                            tagMap.put(tag, tagMap.get(tag)-1);
                        } else {
                            //SYNTAX ERROR: wrong tag
                            errorFlag = true;
                            break;
                        }
                        //tagMap
                    } else {
                        //tagStack
                        tagStack.offerLast(tag);
                        //tagMap
                        if(!tagMap.containsKey(tag)) {
                            tagMap.put(tag, 1);
                        } else {
                            tagMap.put(tag, tagMap.get(tag)+1);
                        }
                    }
                    //slashFlag may not return to false here, unless this situation: </aaa
                    //solve next '>'
                    if (slashFlag && (indexCounter >= line.length() || line.charAt(indexCounter) != '>')) {
                        //SYNTAX ERROR: lack of last '>'
                        slashFlag = false;
                        errorFlag = true;
                        break;
                    }
                }
                //it would be wrong if a '/' occur without include in "<>"
                if (line.charAt(indexCounter) == '/') {
                    //SYNTAX ERROR: wrong '/'
                    errorFlag = true;
                    break;
                }
                indexCounter++;
            }
            rowCounter++;
        }

        return errorFlag;

    }


    //use java bufferreader to read one file
    public List<String> readFile(String fileName)
    {
        //String fileName="/";
        String line = "";
        List<String> result = new LinkedList<>();
        try
        {
            BufferedReader in=new BufferedReader(new FileReader(fileName));
            line = in.readLine();
            result.add(line);
            while (line!=null)
            {
                System.out.println(line);
                line=in.readLine();
                result.add(line);
            }
            in.close();
            return result;
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return result;
    }


    //Warning init function
    //Call it when the first time checker find a error: dicide by warningFlag.
    public static void writeWarningInit(String fileName, Map<Integer, List<String>> warningMap)
    {
        //String fileName="/logWarning";
        try
        {
            BufferedWriter out=new BufferedWriter(new FileWriter(fileName));
            out.write(fileName);
            out.newLine();
            out.write("Warning:");
            out.close();
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //Warning function
    //use java bufferwriter to write warning to one file
    //only one error would be write, but still use map here.
    public static void writeWarning(String fileName, Map<Integer, List<String>> warningMap)
    {
        //String fileName="/logWarning";
        try
        {
            BufferedWriter out=new BufferedWriter(new FileWriter(fileName));
            out.newLine();
            out.write("Warning line: Warning number - Warning detail\n");
            out.close();
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //Error function
    //use java bufferwriter to write error to one file
    public static void writeError(String fileName, Map<Integer, List<String>> errorMap)
    {
        //String fileName="/logError";
        try
        {
            BufferedWriter out=new BufferedWriter(new FileWriter(fileName));
            out.write("Error:");
            out.newLine();
            out.write("Error line: Error number - Error detail\n");
            out.close();
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
