
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author brothrock
 */
public class StockIO {

    //attributes
    private String fileName;

    //constructors
    public StockIO() {
        fileName = "Stocks.txt";
    }

    //behaviors
    public ArrayList<Stock> getData() {
        //create arraylist
        ArrayList<Stock> data = new ArrayList<Stock>();

        try {
            //load the arraylist with the data from the file
            BufferedReader inFile = new BufferedReader(new FileReader(fileName));
            String inputLine = "";
            StringTokenizer tokens;
            
            // get the first line
            inputLine = inFile.readLine();
            
            // cycle through the file and read line by line
            while( inputLine != null )
            {
                //break the line into parts
                tokens = new StringTokenizer( inputLine, ",");
                String company = tokens.nextToken();
                double shares = Double.parseDouble(tokens.nextToken());
                double pPrice = Double.parseDouble(tokens.nextToken());
                double cPrice = Double.parseDouble(tokens.nextToken());
                
                //Create a stock object and add it to the ArrayList
                Stock stk = new Stock( company, shares, pPrice, cPrice );
                data.add(stk);
                
                //read the next line in the file
                inputLine = inFile.readLine();
            }
            
            //close the file
            inFile.close();
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error. Unable to read from the file: " + ex.getMessage(),
                    fileName, JOptionPane.ERROR_MESSAGE);
        }

        //return the arrayList
        return data;
    }

    public void saveData(ArrayList<Stock> data) {
        //Apple,100,55.0,80.0
        try {
            //create a pipe to the file
            BufferedWriter outFile = new BufferedWriter(new FileWriter(fileName));

            //write the stocks by cycling through the data
            for (int i = 0; i < data.size(); i++) {
                Stock stk = data.get(i);
                outFile.write(stk.getCompanyName() + ',');
                outFile.write("" + stk.getNumberOfShares() + ',');
                outFile.write("" + stk.getPurchasePrice() + ',');
                outFile.write("" + stk.getCurrentPrice());
                outFile.newLine();      // ENTER key to drop to next line
            }
            //close the file
            outFile.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error. Unable to write to the file: " + ex.getMessage(),
                    fileName, JOptionPane.ERROR_MESSAGE);
        }
    }

    public StockIO(String fileName) {
        setFileName(fileName);
    }

    //getters and setters
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        if (fileName.length() > 0) {
            this.fileName = fileName;
        } else {
            this.fileName = "Stocks.txt";
        }
    }

}
