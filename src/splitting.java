import java.io.*;
import java.util.Scanner;

public class splitting {
    // ფაილის წაკითხვა, როგორც კი # დაინახავს მაგის მერე ჰოსტნეიმის შენახვა და ამგის მერე დასპლიტვა და მერე ცალკე ფაილში ჩაწერა
    static String name;
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new FileReader("/Users/ketikakhniauri/IdeaProjects/Splitter/src/mycsv.txt"));
        //Scanner scan = new Scanner("test.txt");
        //LineNumberReader nbr = new LineNumberReader(new FileReader("/Users/ketikakhniauri/IdeaProjects/Splitter/mycsv.txt"));
        System.out.println("01");
        //System.out.println(br.readLine());
        try {

            String filename;
            System.out.println("02");
            String line=null;
            line = br.readLine();
            System.out.println(line);
            while (true) {

                if(line.equals("########################################################################") ){

                    System.out.println("# movedi");
                    //int firstnum = nbr.getLineNumber();
                    filename=br.readLine();
                    line=filename;
                    name=filename.substring(filename.indexOf('<') + 1, filename.indexOf('>'));

                    String data=null;
                    while (!line.equals( "########################################################################")){
                        //StringBuilder sb = new StringBuilder();
                        //System.out.println(sb.append(line).append(File.pathSeparatorChar).toString());
                        //data+=sb.append(line).append(File.pathSeparatorChar).toString();
                        data+=line+"\r\n";
                        line=br.readLine();
                    }
                    writeFile(data,name);
                    System.out.println("chawera gamovidzaxe");
                }
            }
        } finally {
            br.close();
           // nbr.close();
        }
    }
    public static void writeFile(String data,String fileName) {
        try {
            File file = new File("/Users/ketikakhniauri/IdeaProjects/Splitter/"+fileName); // Relative path, if not, create a new output.txt file
            if (!file.exists()) {
                file.createNewFile();
            }
            try (FileWriter writer = new FileWriter(file);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
                if (data.equals("")){
                    out.write(data);
                }else{
                    out.write(data+"\r\n");//
                }
                System.out.println("movrchi");
                out.flush();
                out.close();
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
