//package co.com.patios.mb.util;
//
//import java.io.IOException;
//
//import javax.faces.bean.ManagedBean;
//
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFCellStyle;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.hssf.util.HSSFColor;
//
//import com.lowagie.text.BadElementException;
//import com.lowagie.text.Document;
//import com.lowagie.text.DocumentException;
//import com.lowagie.text.Element;
//import com.lowagie.text.Font;
//import com.lowagie.text.PageSize;
//import com.lowagie.text.Paragraph;
//
//@ManagedBean(name = "reportesMB")
//public class ReportesMB {
//
//	
//	
//	public void procesarXLS(Object documetXls) {
//		HSSFWorkbook wb = (HSSFWorkbook) documetXls;
//		HSSFSheet sheet = wb.getSheetAt(0);
//		HSSFRow header = sheet.getRow(0);
//
//		HSSFCellStyle cellStyle = wb.createCellStyle();
//		cellStyle.setFillForegroundColor(HSSFColor.GREEN.index);
//		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//
//		for (int i = 0; i < header.getPhysicalNumberOfCells(); i++) {
//			HSSFCell cell = header.getCell(i);
//			cell.setCellStyle(cellStyle);
//		}
//
//	}
//	
//	
//	  public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
//	        Document pdf = (Document) document;
//	        pdf.setPageSize(PageSize.LETTER.rotate());
//	        pdf.open();
//	        Font font = new Font();
//	        font.setStyle(Font.BOLD);
//	        Paragraph paragraph = new Paragraph("AQUI EL TITULO DE LA EMPRESA O ENTIDAD DE LA CUAL SE GENERA EL REPORTE",font);
//	        paragraph.setSpacingAfter(20);
//	        paragraph.setAlignment(Element.ALIGN_CENTER);
//	        pdf.add(paragraph);
//	        
//	    }
//
//}
