package com.hanon.system.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.hanon.system.model.FileDetails;
import com.hanon.system.service.StockService;

@Service("StockService")
public class StockServiceImpl implements StockService {
	

	private String fileUploadDirectory = "C:/upload_files";

	

	    @Value("${amazonProperties.endpointUrl}")
	    private String endpointUrl;
	    @Value("${amazonProperties.bucketName}")
	    private String bucketName;
	    @Value("${amazonProperties.accessKey}")
	    private String accessKey;
	    @Value("${amazonProperties.secretKey}")
	    private String secretKey;
	  
	    private AmazonS3 s3client;
		@PostConstruct
	    private void initializeAmazon() {
			
	        AWSCredentials credentials = new BasicAWSCredentials("AKIAIECEWXETPEJEXYJQ","JyWsgt825g3rhHNDRiWJYfzrnv4SIz6fuXWPsejY");
	        this.s3client = new AmazonS3Client(credentials);
	    }
		
	@Override
	public Map uploadStocksFile(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf;

		Map<String, Object> files = null;
		List list = new LinkedList<>();
		while (itr.hasNext()) {
			mpf = request.getFile(itr.next());

			String newFilenameBase = UUID.randomUUID().toString();
			String originalFileExtension = mpf.getOriginalFilename()
					.substring(mpf.getOriginalFilename().lastIndexOf("."));
			String fileNameNew = newFilenameBase + originalFileExtension;
		//	String storageDirectory = fileUploadDirectory;
			// Path path = (Path) Paths.get(storageDirectory);

			// if (!Files.exists(path)) {
			// Files.createDirectories(path);
			// }

			String contentType = mpf.getContentType();

		//	File newFile = new File(storageDirectory + "/" + fileNameNew);
		//	String newFileNameWithPath = storageDirectory + "/" + fileNameNew;
			FileDetails fileDetails = null;		
			
		//	mpf.transferTo(newFile);
			File newFile =  convertMultiPartToFile(mpf);
	//		uploadFileTos3bucket(fileNameNew, newFile);
			String newExcelFileName = readStockFileWriteAsExcel(newFile);
			
			fileDetails = new FileDetails();
			fileDetails.setName(mpf.getOriginalFilename());
			fileDetails.setSize(mpf.getSize());
			fileDetails.setNewFilename(newExcelFileName);
			fileDetails.setType(contentType);
			fileDetails.setRec_status("A");

			
			// masterMapper.insertFileRepo(fileRepo);
			// long fileId = fileRepo.getFile_id();
			// log.info("Uploaded File Id " +fileId);
			// fileRepo.setUrl(ctxPath + "folder/" +fileId);

			// fileRepo.setCreate_dttm();
			// fileRepo.setDeleteUrl(ctxPath + "delete/" + fileId);
			// fileRepo.setDeleteType("DELETE");
			list.add(fileDetails);
			// list.add(doc);

		}

		files = new HashMap<>();
		files.put("files", list);

		return files;
	}

	private String readStockFileWriteAsExcel(File fileNameNew) throws Exception {

		/*S3Object object = s3client.getObject(new GetObjectRequest("elasticbeanstalk-us-east-2-968470451838", filePath));
	//	InputStream objectData = object.getObjectContent();
		
		 System.out.println(object.getObjectMetadata().getContentType());
		    System.out.println(object.getObjectMetadata().getContentLength());

		    BufferedReader reader = new BufferedReader(new InputStreamReader(s3object.getObjectContent()));
		    String line;
		    while((line = reader.readLine()) != null) {
		      // can copy the content locally as well
		      // using a buffered writer
		      System.out.println(line);
		    }*/
		    
/*	//	final AmazonS3Client s3Client = AmazonS3ClientBuilder.defaultClient(); 
		 S3Object object = s3client.getObject("elasticbeanstalk-us-east-2-968470451838", fileNameNew);
		
		// with Java 7 NIO
		final Path filePath = Paths.get(fileNameNew);		 
		Files.copy(object.getObjectContent(), filePath);
		final File localFile = filePath.toFile();*/

		
		String[] headers = new String[] {"Company", "Part Number", "DESCRIPTION", "PROG","VARIANT", "COMMODITY","LINE Stock","STORE stock","STOCK","CUS PLAN","FIRM","TENTATIVE","Shortage Qty"};

//		Workbook workbook = new HSSFWorkbook();
//		Sheet sheet = workbook.createSheet("EDR Raw Data");

		
		
		
		
		
		FileInputStream file = new FileInputStream(fileNameNew);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		String newExcelFileName = null;
		
		Workbook newWB = new XSSFWorkbook();
		Sheet newSheet = newWB.createSheet("Hanon");
		
		
		
		int rowCount = 1;
		
		 Row nwRow = newSheet.createRow(rowCount);
			for (int rn=0; rn<headers.length; rn++) {
				  
				nwRow.createCell(rn).setCellValue(headers[rn]);
				}
			
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			System.out.println("sheet no : " + (i + 1) + wb.getSheetAt(i).getSheetName());
			CreationHelper createHelper = wb.getCreationHelper();
			XSSFSheet sheet = wb.getSheetAt(i);

			// HSSFSheet sheet = wb.getSheetAt(i);
			
			int rwCounttest = 0;
			for (Row myrow : sheet) {
				rwCounttest = rwCounttest + 1;
				if (myrow.getRowNum() > 9) {
					// System.out.println("Mycell 17: " +
					// myrow.getCell(17).getNumericCellValue() + " row num :" +
					// myrow.getRowNum());
					/*
					 * if (null != myrow.getCell(17).getStringCellValue() &&
					 * !myrow.getCell(17).getStringCellValue().equals("")) {
					 */
					if (null != myrow.getCell(16)) {
						
						double col16 = myrow.getCell(16).getNumericCellValue();

			//			
						/*
						 * double col17 =
						 * myrow.getCell(17).getNumericCellValue();
						 * System.out.println("Mycell 17: " + col17); double
						 * col18 = myrow.getCell(18).getNumericCellValue();
						 * System.out.println("Mycell 18: " + col18);
						 */

						// if ((col17 < 0) || (col18 < 0) || (col16 < 0)) {
						if ((col16 < 0)) {
							
						//	Cell cell = myrow.getCell(c);
						//	Cell newCell = newRow.createCell(c);
				//		System.out.println("rowcount:: " + rwCounttest + "    Mycell 16: " + col16);
							Row newRow = newSheet.createRow(++rowCount);
							
							newRow.createCell(0).setCellValue(
									createHelper.createRichTextString(wb.getSheetAt(i).getSheetName()));							
							newRow.createCell(1).setCellValue(
									createHelper.createRichTextString(myrow.getCell(2).getStringCellValue()));	
							newRow.createCell(2).setCellValue(
									createHelper.createRichTextString(myrow.getCell(3).getStringCellValue()));	
							newRow.createCell(3).setCellValue(
									createHelper.createRichTextString(myrow.getCell(4).getStringCellValue()));	
						/*	newRow.createCell(4).setCellValue(
									createHelper.createRichTextString(myrow.getCell(5).getStringCellValue()));	
							newRow.createCell(5).setCellValue(
									createHelper.createRichTextString(myrow.getCell(6).getStringCellValue()));	*/						
							newRow.createCell(6).setCellValue(myrow.getCell(9).getNumericCellValue());
							newRow.createCell(7).setCellValue(myrow.getCell(10).getNumericCellValue());
							newRow.createCell(8).setCellValue(myrow.getCell(11).getNumericCellValue());
							newRow.createCell(9).setCellValue(myrow.getCell(12).getNumericCellValue());
							newRow.createCell(10).setCellValue(myrow.getCell(13).getNumericCellValue());
							newRow.createCell(11).setCellValue(myrow.getCell(14).getNumericCellValue());
							newRow.createCell(12).setCellValue(myrow.getCell(15).getNumericCellValue());
							newRow.createCell(13).setCellValue(myrow.getCell(16).getNumericCellValue());
							newRow.createCell(14).setCellValue(myrow.getCell(17).getNumericCellValue());
						
							
						}

						// Finally add the table to PDF document
						// iText_xls_2_pdf.add(my_table);
					}
				}
				// iText_xls_2_pdf.close();
				// we created our pdf file..

				// return iText_xls_2_pdf;
			}
		//	System.out.println("sheet no : " + (i + 1) + " || row count : " + rwCounttest);

		}
		
		Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyHHmmss");  
	    String strDate= formatter.format(date);  
	    File tempAwsFile = File.createTempFile("workbook-"+strDate, ".xls");
	    newExcelFileName = "workbook-"+strDate+".xls";
		FileOutputStream fileOut = new FileOutputStream(tempAwsFile);
		
		newWB.write(fileOut);
		 Writer writer = new OutputStreamWriter(fileOut);
		 uploadFileTos3bucket(newExcelFileName, tempAwsFile);
		 writer.close();
		fileOut.close();

		file.close();
//		System.out.println("Deleting.. "+ filePath);
		
//		File tempFile = new File(filePath);    	
//		tempFile.delete();
		return newExcelFileName;
	}

	
	
	private void uploadFileTos3bucket(String fileName, File file) throws IOException {
	//	System.out.println("file : "+file.);
		System.out.println("fileName : "+fileName);
//		 for (Bucket bucket : s3client.listBuckets()) {
//             System.out.println(" - " + bucket.getName());
//         }
		 
	    s3client.putObject(new PutObjectRequest("elasticbeanstalk-us-east-2-968470451838", fileName, file)
	            .withCannedAcl(CannedAccessControlList.PublicRead));
	}
	
	private File convertMultiPartToFile(MultipartFile file) throws IOException {
	  /*  File convFile = new File(file.getOriginalFilename());
	    FileOutputStream fos = new FileOutputStream(convFile);
	    fos.write(file.getBytes());
	    fos.close();
	    return convFile;*/
		File convFile = File.createTempFile("aws-java-sdk-temp", ".xlsx");
		
		convFile.deleteOnExit();
		 FileOutputStream fos = new FileOutputStream(convFile);
		    fos.write(file.getBytes());
		    fos.close();
		    return convFile;
	}
	
	private static File createSampleFile() throws IOException {
        File file = File.createTempFile("aws-java-sdk-", ".txt");
        file.deleteOnExit();

        Writer writer = new OutputStreamWriter(new FileOutputStream(file));
        writer.write("abcdefghijklmnopqrstuvwxyz\n");
        writer.write("01234567890112345678901234\n");
        writer.write("!@#$%^&*()-=[]{};':',.<>/?\n");
        writer.write("01234567890112345678901234\n");
        writer.write("abcdefghijklmnopqrstuvwxyz\n");
        writer.close();

        return file;
    }

}