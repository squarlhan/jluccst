/**
 * Copyright (c) 2012 Changchun CBIT Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)PoiUtil.java 1.1 2012-4-8
 */

package com.boan.crm.utils.poi;


/**
 * Poi工具类 
 * @author ZhuYF
 * @version 1.0.0
 */
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Bookmark;
import org.apache.poi.hwpf.usermodel.Bookmarks;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;

public class PoiUtil {

	/**
	 * 处理docx类型的word文件
	 * @param srcPath  模板路径
	 * @param destPath 替换模板后的文件
	 * @param map      参数集合
	 */
	public static void replaceTempletBookmarkForDocx(String srcPath, String destPath, Map<String, String> map) {
		try {
			XWPFDocument document = new XWPFDocument( POIXMLDocument.openPackage(srcPath));

			//不在表格中的书签处理
			List<XWPFParagraph> itParagraph = document.getParagraphs();
			for(XWPFParagraph paragraph : itParagraph){
				CTP ctp = paragraph.getCTP();
				List<CTBookmark> bookmarks = ctp.getBookmarkStartList();
				for (CTBookmark bookmark : bookmarks) {
					for (Map.Entry<String,String> entry:map.entrySet()) {
						if(bookmark.getName().equals(entry.getKey())){
							CTR ctr = ctp.addNewR();
							CTText text = ctr.addNewT();
							text.setStringValue(entry.getValue());
						}
					} 
				}
			}
			
			//表格中的书签处理
			Iterator<XWPFTable> tables_it1 = document.getTablesIterator();
			while (tables_it1.hasNext()) {
				XWPFTable table1 = tables_it1.next();
				//int size = table1.getRow(0).getCtRow().sizeOfTcArray();
				List<XWPFTableRow> rows  = table1.getRows();
				for (XWPFTableRow row : rows) {
					List<XWPFTableCell> cells = row.getTableCells();
					for (XWPFTableCell c : cells) {
						List<XWPFParagraph> paragraphs = c.getParagraphs();
						for (XWPFParagraph paragraph : paragraphs) {
							CTP ctp = paragraph.getCTP();
							List<CTBookmark> bookmarks = ctp.getBookmarkStartList();
							for (CTBookmark bookmark : bookmarks) {
								System.out.println(bookmark.getName());
								for (Map.Entry<String,String> entry:map.entrySet()) {
									if(bookmark.getName().equals(entry.getKey())){
										CTR ctr = ctp.addNewR();
										CTText text = ctr.addNewT();
										text.setStringValue(entry.getValue());
									}
								} 
							}
						}
					}
				}
			}
			FileOutputStream outStream = new FileOutputStream(destPath);
			document.write(outStream);
			outStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 处理doc类型的word文件
	 * @param srcPath  模板路径
	 * @param destPath 替换模板后的文件
	 * @param map      参数集合
	 */
	public static void replaceTempletBookmarkForDoc(String srcPath, String destPath, Map<String, String> map) {
		try {
			// 读取word模板
			FileInputStream fis = new FileInputStream(srcPath);
			HWPFDocument wdDoc = new HWPFDocument(fis);
			Bookmarks bkmkList = wdDoc.getBookmarks();
			int bkmkCount = bkmkList.getBookmarksCount();

			for (int i = 0; i < bkmkCount; i++) {
				Bookmark bkmk = bkmkList.getBookmark(i); 
				System.out.println(bkmk.getName());
				for (Map.Entry<String,String> entry:map.entrySet()) {
					if(bkmk.getName().equals(entry.getKey())){
						Range bkmkRange = new Range(bkmk.getStart(), bkmk.getEnd(), wdDoc);
		                bkmkRange.insertAfter(entry.getValue());
					}
				} 
			}

			ByteArrayOutputStream ostream = new ByteArrayOutputStream();

			FileOutputStream outStream = new FileOutputStream(destPath,true);
			wdDoc.write(ostream);
            //输出字节流
			outStream.write(ostream.toByteArray());
			outStream.close();
			ostream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据word文档类型选择不同的处理方式
	 * @param srcPath  模板路径
	 * @param destPath 导出文件路径
	 * @param map      模板值
	 */
	public static void wordProcessor(String srcPath, String destPath, Map<String, String> map) {
		String suffixal = srcPath.substring(srcPath.lastIndexOf('.'));
		if (suffixal.equals(".docx")) {
			replaceTempletBookmarkForDocx(srcPath, destPath, map);
		} else if (suffixal.equals(".doc")) {
			replaceTempletBookmarkForDoc(srcPath, destPath, map);
		} else {
			System.out.println("模板错误！");
		}
	}
	
	/**
	 * 处理docx类型的word文件
	 * @param srcPath  模板路径
	 * @param outStream 输出流 
	 * @param map      参数集合
	 */
	public static ByteArrayOutputStream replaceTempletBookmarkForDocx(String srcPath, Map<String, String> map) {
		ByteArrayOutputStream ostream = new ByteArrayOutputStream();
		try {
			XWPFDocument document = new XWPFDocument( POIXMLDocument.openPackage(srcPath));
			
			//不在表格中的书签处理
			List<XWPFParagraph> itParagraph = document.getParagraphs();
			for(XWPFParagraph paragraph : itParagraph){
				CTP ctp = paragraph.getCTP();
				List<CTBookmark> bookmarks = ctp.getBookmarkStartList();
				for (CTBookmark bookmark : bookmarks) {
					for (Map.Entry<String,String> entry:map.entrySet()) {
						if(bookmark.getName().equals(entry.getKey())){
							CTR ctr = ctp.addNewR();
							CTText text = ctr.addNewT();
							text.setStringValue(entry.getValue());
						}
					} 
				}
			}
			
			//表格中的书签处理
			Iterator<XWPFTable> tables_it1 = document.getTablesIterator();
			while (tables_it1.hasNext()) {
				XWPFTable table1 = tables_it1.next();
				//int size = table1.getRow(0).getCtRow().sizeOfTcArray();
				List<XWPFTableRow> rows  = table1.getRows();
				for (XWPFTableRow row : rows) {
					List<XWPFTableCell> cells = row.getTableCells();
					for (XWPFTableCell c : cells) {
						List<XWPFParagraph> paragraphs = c.getParagraphs();
						for (XWPFParagraph paragraph : paragraphs) {
							CTP ctp = paragraph.getCTP();
							List<CTBookmark> bookmarks = ctp.getBookmarkStartList();
							for (CTBookmark bookmark : bookmarks) {
								for (Map.Entry<String,String> entry:map.entrySet()) {
									if(bookmark.getName().equals(entry.getKey())){
										CTR ctr = ctp.addNewR();
										CTText text = ctr.addNewT();
										text.setStringValue(entry.getValue());
									}
								} 
							}
						}
					}
				}
			}
			document.write(ostream);
			ostream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ostream;
	}
	
	/**
	 * 处理doc类型的word文件
	 * @param srcPath  模板路径
	 * @param outStream 输出流
	 * @param map      参数集合
	 */
	public static ByteArrayOutputStream replaceTempletBookmarkForDoc(String srcPath, Map<String, String> map) {
		ByteArrayOutputStream ostream = new ByteArrayOutputStream();
		try {
			// 读取word模板
			FileInputStream fis = new FileInputStream(srcPath);
			HWPFDocument wdDoc = new HWPFDocument(fis);
			Bookmarks bkmkList = wdDoc.getBookmarks();
			int bkmkCount = bkmkList.getBookmarksCount();
			
			for (int i = 0; i < bkmkCount; i++) {
				Bookmark bkmk = bkmkList.getBookmark(i); 
				for (Map.Entry<String,String> entry:map.entrySet()) {
					if(bkmk.getName().equals(entry.getKey())){
						Range bkmkRange = new Range(bkmk.getStart(), bkmk.getEnd(), wdDoc);
						bkmkRange.insertAfter(entry.getValue());
					}
				} 
			}
			
			wdDoc.write(ostream);
			ostream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ostream;
	}
	
	/**
	 * 根据word文档类型选择不同的处理方式
	 * @param srcPath  模板路径
	 * @param destPath 导出文件路径
	 * @param map      模板值
	 */
	public static ByteArrayOutputStream wordProcessor(String srcPath, Map<String, String> map) {
		String suffixal = srcPath.substring(srcPath.lastIndexOf('.'));
		if (suffixal.equals(".docx")) {
			return replaceTempletBookmarkForDocx(srcPath, map);
		} else if (suffixal.equals(".doc")) {
			return replaceTempletBookmarkForDoc(srcPath,map);
		} else {
			System.out.println("模板错误！");
			return null;
		}
	}

	public static void main(String[] args) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "张三");
		map.put("sex", "女");
		map.put("age", "24");
		map.put("memo", "师德师风 ");
		map.put("out", "外部内容");
		String fileDir = new File(PoiUtil.class.getResource("").getFile(),
				"../../../../doc/").getCanonicalPath().replaceAll("%20", " ");
		String srcPath = fileDir + "\\test.doc";
		String destPath = fileDir + "\\2.doc";
		wordProcessor(srcPath, destPath, map);
	}
}
