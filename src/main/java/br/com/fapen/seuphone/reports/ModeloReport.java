package br.com.fapen.seuphone.reports;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;

@Component
public class ModeloReport {

	
	public void adicionaTitulo(Document documento, String titulo) {
		documento.add(new Paragraph(titulo).setBold().setTextAlignment(TextAlignment.CENTER).setFontSize(24));
	}

	public ByteArrayInputStream helloWorld() {
		ByteArrayOutputStream outputStreamPDF = new ByteArrayOutputStream();
		
		PdfWriter writer = new PdfWriter(outputStreamPDF);
		PdfDocument pdfDoc = new PdfDocument(writer);
		// A4 por padrão
		Document documento = new Document(pdfDoc, PageSize.A4);
		
		
		
		try {
			
			Image imgTeste = new Image(ImageDataFactory.create("/home/emerson/Downloads/img-test.png"));
			imgTeste.setWidth(200);
			
			documento.add(new Paragraph().add(imgTeste).setTextAlignment(TextAlignment.CENTER));
			adicionaTitulo(documento, "Pedido de Compra");
			
			documento.add(new Paragraph("Hello World").setBold());
			
			Text texto = new Text("Primeiro texto...");
			Paragraph p1 = new Paragraph();
			p1.add(texto);
			p1.add("String sendo passada direto").add("AAAA");
			
			documento.add(p1);
			
			Paragraph p2 = new Paragraph("Alteração de Fonte").setFontSize(24);
			Paragraph p3 = new Paragraph("Minha cor mudou?").setFontColor(ColorConstants.RED);
			
			documento.add(p2);
			documento.add(p3);
			
			for(int i = 0; i<5; i++) {
				documento.add(new Paragraph("Texto " + i));
			}
			
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("Erro na geração do PDF -->" + e.getMessage());
		}
		
		documento.close();
		return new ByteArrayInputStream(outputStreamPDF.toByteArray());
	}
}
