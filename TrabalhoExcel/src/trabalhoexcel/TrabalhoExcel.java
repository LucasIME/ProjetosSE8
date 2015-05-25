/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoexcel;

/**
 *
 * @author Pedro
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import javafx.scene.control.Cell;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Row;

public class TrabalhoExcel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        
        Random rand = new Random();
        
        FileInputStream input = new FileInputStream("C:/Users/Pedro/Desktop/PlanilhaOrcamentoPessoalEdu.xls");
        
        HSSFWorkbook workbook = new HSSFWorkbook(input);
        
        HSSFSheet sheet = workbook.getSheetAt(0);
        
        HSSFCell cell = null;
        
        for(int i=4; i<16;i++){
            cell = sheet.getRow(5).getCell(i);
            cell.setCellValue(150000);
        }
        
        for(int i=4; i<16;i++){
            for(int j=6;j<109;j++){
                cell = sheet.getRow(j).getCell(i);
                if( !sheet.getRow(j).getCell(3).isPartOfArrayFormulaGroup() && !sheet.getRow(j).getCell(3).getStringCellValue().equals("") ) cell.setCellValue(4000*rand.nextFloat());
            }
        }
        
        input.close();
        
        FileOutputStream output = new FileOutputStream("C:/Users/Pedro/Desktop/PlanilhaOrcamentoPessoalEdu.xls");
        workbook.write(output);
        output.close();

        
    }
    
}
