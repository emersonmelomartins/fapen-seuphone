package br.com.fapen.seuphone.reports;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;

import br.com.fapen.seuphone.models.DescricaoPedido;
import br.com.fapen.seuphone.models.PedidoCompra;

@Component
public class PedidoCompraReport {

	@Autowired
	private ResourceLoader resourceLoader;

	public void adicionaTitulo(Document documento, String titulo) {
		documento.add(new Paragraph(titulo).setBold().setTextAlignment(TextAlignment.CENTER).setFontSize(24));
	}

	public void adicionaLogo(Document documento) throws IOException {
		String logo = resourceLoader.getResource("/WEB-INF/logo.png").getFile().getAbsolutePath();
		Image imgLogo = new Image(ImageDataFactory.create(logo));
		imgLogo.setWidth(100);
		documento.add(new Paragraph().add(imgLogo).setTextAlignment(TextAlignment.CENTER));
	}

	public ByteArrayInputStream gerarPdf(PedidoCompra pedidoImpresso) {
		ByteArrayOutputStream outputStreamPDF = new ByteArrayOutputStream();

		PdfWriter writer = new PdfWriter(outputStreamPDF);
		PdfDocument pdfDoc = new PdfDocument(writer);
		// A4 por padrão
		Document documento = new Document(pdfDoc, PageSize.A4);
		
		

		try {
			// Cabeçalho
			adicionaLogo(documento);
			adicionaTitulo(documento, "Pedido de Compra N° " + pedidoImpresso.getIdPedido());
			
			// Dados do Pedido
			float [] tamanhoColunas2 = {3, 3}; 
			Table tabelaDadosPedido = new Table(tamanhoColunas2); 
			tabelaDadosPedido.setBorder(Border.NO_BORDER);
			
			Cell cell1 = new Cell().setBorder(Border.NO_BORDER);
			cell1.add(new Paragraph("Data do Pedido").setBold()); 
			tabelaDadosPedido.addCell(cell1);
			
			Cell cell2 = new Cell().setBorder(Border.NO_BORDER);
			cell2.add(new Paragraph(pedidoImpresso.getDtPedido()
					.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
					.toString())); 
			tabelaDadosPedido.addCell(cell2);
			
			cell1 = new Cell().setBorder(Border.NO_BORDER);
			cell1.add(new Paragraph("Data de Entrega").setBold()); 
			tabelaDadosPedido.addCell(cell1);
			
			cell2 = new Cell().setBorder(Border.NO_BORDER);
			cell2.add(new Paragraph(pedidoImpresso.getDtEntrega()
					.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
					.toString())); 
			tabelaDadosPedido.addCell(cell2);

			cell1 = new Cell().setBorder(Border.NO_BORDER);
			cell1.add(new Paragraph("Fornecedor").setBold()); 
			tabelaDadosPedido.addCell(cell1);
			
			cell2 = new Cell().setBorder(Border.NO_BORDER);
			cell2.add(new Paragraph(pedidoImpresso.getFornecedor().getRazaoSocial().toString())); 
			tabelaDadosPedido.addCell(cell2);
			
			cell1 = new Cell().setBorder(Border.NO_BORDER);
			cell1.add(new Paragraph("Método de Pagamento").setBold()); 
			tabelaDadosPedido.addCell(cell1);
			
			cell2 = new Cell().setBorder(Border.NO_BORDER);
			cell2.add(new Paragraph(pedidoImpresso.getCondicaoPagamento().getDisplayValue())); 
			tabelaDadosPedido.addCell(cell2);
			
			cell1 = new Cell().setBorder(Border.NO_BORDER);
			cell1.add(new Paragraph("Situação").setBold()); 
			tabelaDadosPedido.addCell(cell1);
			
			cell2 = new Cell().setBorder(Border.NO_BORDER);
			cell2.add(new Paragraph(pedidoImpresso.getSituacaoPedido().getDisplayValue())); 
			tabelaDadosPedido.addCell(cell2);
		
			documento.add(tabelaDadosPedido);

			// Descrição do Pedido
			
			float[] tamanhoColunas = { 2, 5 };

			Table tabelaLayout = new Table(UnitValue.createPercentArray(tamanhoColunas)).useAllAvailableWidth();
			
			tabelaLayout.addCell(new Cell(1, 2)
					.add(new Paragraph("Itens do Pedido").setBold().setTextAlignment(TextAlignment.CENTER)));
			String[] cabecalhoItens = { "Cód.", "Descrição", "Qtde.", "Val. Unitário", "Total" };
			float[] tamColunaItens = { 1, 3, 1, 1, 1 };

			Table tabelaItens = new Table(UnitValue.createPercentArray(tamColunaItens)).useAllAvailableWidth();
			for (String linha : cabecalhoItens) {
				tabelaItens
						.addHeaderCell(new Paragraph(linha).setBold().setTextAlignment(TextAlignment.CENTER));
			}
			
			for (int cont = 0; cont < pedidoImpresso.getItens().size(); cont++) {
				DescricaoPedido itemPed = pedidoImpresso.getItens().get(cont);
				tabelaItens.addCell(new Paragraph(itemPed.getProduto().getIdProduto().toString())
						.setTextAlignment(TextAlignment.CENTER));
				tabelaItens.addCell(new Paragraph(itemPed.getProduto().getDescricao().toString())
						.setTextAlignment(TextAlignment.CENTER));
				tabelaItens.addCell(new Paragraph(itemPed.getQuantidade().toString())
						.setTextAlignment(TextAlignment.CENTER));
				tabelaItens.addCell(new Paragraph(itemPed.getProduto().getValor().toString())
						.setTextAlignment(TextAlignment.CENTER));
				tabelaItens.addCell(new Paragraph(itemPed.getValor().toString())
						.setTextAlignment(TextAlignment.CENTER));
			}
			
			tabelaItens.addCell(
					new Cell(1, 4).add(new Paragraph("Valor Final").setTextAlignment(TextAlignment.RIGHT)));
			tabelaItens.addCell(new Cell(1, 1).add(new Paragraph(pedidoImpresso.getValorFinal().toString()).setBold()
					.setTextAlignment(TextAlignment.CENTER)));
			
			documento.add(tabelaLayout);
			documento.add(tabelaItens);

			

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erro na geração do PDF -->" + e.getMessage());
		}

		documento.close();
		return new ByteArrayInputStream(outputStreamPDF.toByteArray());
	}
}
