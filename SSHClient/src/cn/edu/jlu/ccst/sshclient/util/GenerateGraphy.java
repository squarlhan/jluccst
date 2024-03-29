package cn.edu.jlu.ccst.sshclient.util;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import cn.edu.jlu.ccst.sshclient.ui.LinuxClient;

public class GenerateGraphy {

	public GenerateGraphy() {
	}
	/**
	 * 生成饼图
	 * @param input
	 * @return
	 * @throws IOException
	 */
	public static JFreeChart generatePie(String input) throws IOException {

		JFreeChart chart = ChartFactory.createPieChart3D("", // 图表标题
				getPieDataSet(input), // 数据集
				true, // 是否显示图例(对于简单的柱状图必须是false)
				false, // 是否生成工具
				false // 是否生成URL链接
		);

		//重新设置图标标题，改变字体
		//chart.setTitle(new TextTitle("图书销量统计图", new Font("黑体", Font.ITALIC , 22))); 
		//取得统计图标的第一个图例
		LegendTitle legend = chart.getLegend(0);
		//修改图例的字体
		legend.setItemFont(new Font("宋体", Font.BOLD, 14)); 
		//获得饼图的Plot对象
		PiePlot plot = (PiePlot)chart.getPlot();
		//设置饼图各部分的标签字体
		plot.setLabelFont(new Font("隶书", Font.BOLD, 18)); 
		//设定背景透明度（0-1.0之间）
		plot.setBackgroundAlpha(0.9f);
		//设定前景透明度（0-1.0之间）
		plot.setForegroundAlpha(0.50f);

		// FileOutputStream fos = null;
		// fos = new FileOutputStream("book.jpg");
		// // 将统计图标输出成JPG文件
		// ChartUtilities.writeChartAsJPEG(fos, // 输出到哪个输出流
		// 1, // JPEG图片的质量，0~1之间
		// chart, // 统计图标对象
		// 800, // 宽
		// 600,// 宽
		// null // ChartRenderingInfo 信息
		// );
		// fos.close();
		return chart;
	}
	/**
	 * 生成折线图
	 * @param input
	 * @return
	 * @throws IOException
	 */
	public static JFreeChart generateLine(String input) throws IOException {

		JFreeChart chart = ChartFactory.createLineChart("", // 图表标题
				"", // 目录轴的显示标签
				"", // 数值轴的显示标签
				getLineDataSet(input), // 数据集
				// PlotOrientation.HORIZONTAL , // 图表方向：水平
				PlotOrientation.VERTICAL, // 图表方向：垂直
				true, // 是否显示图例(对于简单的柱状图必须是false)
				false, // 是否生成工具
				false // 是否生成URL链接
		);

		// 重新设置图标标题，改变字体
		// chart.setTitle(new TextTitle("图书销量统计图", new Font("黑体",
		// Font.ITALIC,22)));
		// 取得统计图标的第一个图例
		LegendTitle legend = chart.getLegend(0);
		// 修改图例的字体
		legend.setItemFont(new Font("宋体", Font.BOLD, 14));

		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		// 取得横轴
		CategoryAxis categoryAxis = plot.getDomainAxis();
		// 设置横轴显示标签的字体
		categoryAxis.setLabelFont(new Font("宋体", Font.BOLD, 22));
		// 分类标签以45度角倾斜
		// categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
		categoryAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 18));
		// 取得纵轴
		NumberAxis numberAxis = (NumberAxis) plot.getRangeAxis();
		// 设置纵轴显示标签的字体
		numberAxis.setLabelFont(new Font("宋体", Font.BOLD, 22));

		// FileOutputStream fos = null;
		// fos = new FileOutputStream("book.jpg");
		// // 将统计图标输出成JPG文件
		// ChartUtilities.writeChartAsJPEG(fos, // 输出到哪个输出流
		// 1, // JPEG图片的质量，0~1之间
		// chart, // 统计图标对象
		// 800, // 宽
		// 600,// 宽
		// null // ChartRenderingInfo 信息
		// );
		// fos.close();
		return chart;
	}
	/**
	 * 生成柱状图
	 * @param input
	 * @return
	 * @throws IOException
	 */
	public static JFreeChart generateBar(String input) throws IOException {

		JFreeChart chart = ChartFactory.createBarChart3D("", // 图表标题
				"", // 目录轴的显示标签
				"", // 数值轴的显示标签
				getBarDataSet(input), // 数据集
				// PlotOrientation.HORIZONTAL , // 图表方向：水平
				PlotOrientation.VERTICAL, // 图表方向：垂直
				false, // 是否显示图例(对于简单的柱状图必须是false)
				false, // 是否生成工具
				false // 是否生成URL链接
		);

		// 重新设置图标标题，改变字体
		// chart.setTitle(new TextTitle("图书销量统计图", new Font("黑体",
		// Font.ITALIC,22)));
		// 取得统计图标的第一个图例
		//LegendTitle legend = chart.getLegend(0);
		// 修改图例的字体
		//legend.setItemFont(new Font("宋体", Font.BOLD, 14));

		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		// 取得横轴
		CategoryAxis categoryAxis = plot.getDomainAxis();
		// 设置横轴显示标签的字体
		categoryAxis.setLabelFont(new Font("宋体", Font.BOLD, 22));
		// 分类标签以45度角倾斜
		// categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
		categoryAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 18));
		// 取得纵轴
		NumberAxis numberAxis = (NumberAxis) plot.getRangeAxis();
		// 设置纵轴显示标签的字体
		numberAxis.setLabelFont(new Font("宋体", Font.BOLD, 22));
		//numberAxis.setVisible(false); 
		// FileOutputStream fos = null;
		// fos = new FileOutputStream("book.jpg");
		// // 将统计图标输出成JPG文件
		// ChartUtilities.writeChartAsJPEG(fos, // 输出到哪个输出流
		// 1, // JPEG图片的质量，0~1之间
		// chart, // 统计图标对象
		// 800, // 宽
		// 600,// 宽
		// null // ChartRenderingInfo 信息
		// );
		// fos.close();
		return chart;
	}
	/**
	 * 画出两条线
	 * @param input
	 * @return
	 * @throws IOException
	 */
	public static JFreeChart generate2Line(String input) throws IOException {

		JFreeChart chart = ChartFactory.createLineChart("", // 图表标题
				"", // 目录轴的显示标签
				"", // 数值轴的显示标签
				get2LineDataSet(input), // 数据集
				// PlotOrientation.HORIZONTAL , // 图表方向：水平
				PlotOrientation.VERTICAL, // 图表方向：垂直
				true, // 是否显示图例(对于简单的柱状图必须是false)
				false, // 是否生成工具
				false // 是否生成URL链接
		);

		// 重新设置图标标题，改变字体
		// chart.setTitle(new TextTitle("图书销量统计图", new Font("黑体",
		// Font.ITALIC,22)));
		// 取得统计图标的第一个图例
		LegendTitle legend = chart.getLegend(0);
		// 修改图例的字体
		legend.setItemFont(new Font("宋体", Font.BOLD, 14));

		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		// 取得横轴
		CategoryAxis categoryAxis = plot.getDomainAxis();
		// 设置横轴显示标签的字体
		categoryAxis.setLabelFont(new Font("宋体", Font.BOLD, 22));
		// 分类标签以45度角倾斜
		// categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
		categoryAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 18));
		// 取得纵轴
		NumberAxis numberAxis = (NumberAxis) plot.getRangeAxis();
		// 设置纵轴显示标签的字体
		numberAxis.setLabelFont(new Font("宋体", Font.BOLD, 22));

		// FileOutputStream fos = null;
		// fos = new FileOutputStream("book.jpg");
		// // 将统计图标输出成JPG文件
		// ChartUtilities.writeChartAsJPEG(fos, // 输出到哪个输出流
		// 1, // JPEG图片的质量，0~1之间
		// chart, // 统计图标对象
		// 800, // 宽
		// 600,// 宽
		// null // ChartRenderingInfo 信息
		// );
		// fos.close();
		return chart;
	}
	public static JFreeChart generate2Bar(String input) throws IOException {

		JFreeChart chart = ChartFactory.createBarChart("", // 图表标题
				"", // 目录轴的显示标签
				"", // 数值轴的显示标签
				get2LineDataSet(input), // 数据集
				// PlotOrientation.HORIZONTAL , // 图表方向：水平
				PlotOrientation.VERTICAL, // 图表方向：垂直
				true, // 是否显示图例(对于简单的柱状图必须是false)
				false, // 是否生成工具
				false // 是否生成URL链接
		);

		// 重新设置图标标题，改变字体
		// chart.setTitle(new TextTitle("图书销量统计图", new Font("黑体",
		// Font.ITALIC,22)));
		// 取得统计图标的第一个图例
		LegendTitle legend = chart.getLegend(0);
		// 修改图例的字体
		legend.setItemFont(new Font("宋体", Font.BOLD, 14));

		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		// 取得横轴
		CategoryAxis categoryAxis = plot.getDomainAxis();
		// 设置横轴显示标签的字体
		categoryAxis.setLabelFont(new Font("宋体", Font.BOLD, 22));
		// 分类标签以45度角倾斜
		// categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
		categoryAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 18));
		// 取得纵轴
		NumberAxis numberAxis = (NumberAxis) plot.getRangeAxis();
		// 设置纵轴显示标签的字体
		numberAxis.setLabelFont(new Font("宋体", Font.BOLD, 22));

		// FileOutputStream fos = null;
		// fos = new FileOutputStream("book.jpg");
		// // 将统计图标输出成JPG文件
		// ChartUtilities.writeChartAsJPEG(fos, // 输出到哪个输出流
		// 1, // JPEG图片的质量，0~1之间
		// chart, // 统计图标对象
		// 800, // 宽
		// 600,// 宽
		// null // ChartRenderingInfo 信息
		// );
		// fos.close();
		return chart;
	}

	// 返回线图的数据集
	private static CategoryDataset getLineDataSet(String input) throws IOException {

		File file = new File(input);
		InputStreamReader insr = new InputStreamReader(
				new FileInputStream(file), "gb2312");
		BufferedReader br = new BufferedReader(insr);
		String line;
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		List<Float> datas = new ArrayList<Float>();
		int a = 1;
		while ((line = br.readLine()) != null) {
			// System.out.println(line);
			line = line.trim();
			if (line.trim().length() >= 1) {
				//System.out.println(line);
				for(int i = 0 ;i < 9; ++i)
				{
					int index = line.indexOf(" ");
					String temp = line.substring(0,index);
					datas.add(Float.valueOf(temp));
					line = line.substring(index+1,line.length()).trim();
				}
				datas.add(Float.valueOf(line));
			}

		}
		br.close();
		insr.close();
		List<Float> fdatas = formatdate(datas);
		for (float f : fdatas) {
			dataset.addValue(f, "", "R" + String.valueOf(a++));
		}
		return dataset;
	}
	// 返回2注图的数据集
	private static CategoryDataset get2LineDataSet(String input) throws IOException {

		File file = new File(input);
		InputStreamReader insr = new InputStreamReader(
				new FileInputStream(file), "gb2312");
		BufferedReader br = new BufferedReader(insr);
		String line;
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		List<Float> datas1 = new ArrayList<Float>();
		List<Float> datas2 = new ArrayList<Float>();
		int a = 1,aa = 1;
		while ((line = br.readLine()) != null) {
			line = line.trim();
			if (line.trim().length() >= 1) {
				//System.out.println(line);					
				String[] strs = line.split("       ");
				datas1.add(Float.valueOf(strs[1]));
				datas2.add(Float.valueOf(strs[2]));				
			}else break;

		}
		br.close();
		insr.close();
		List<Float> fdatas1 = formatdate(datas1);
		List<Float> fdatas2 = formatdate(datas2);
		for (float f : fdatas1) {
			dataset.addValue(f, "正解", "Y" + String.valueOf(a++));
			if(a==200)break;
		}
		for (float f : fdatas2) {
			dataset.addValue(f, "测解", "Y" + String.valueOf(aa++));
			if(aa==200)break;
		}
		return dataset;
	}
	//	// 返回2线图的数据集
	//	private static CategoryDataset get2BarDataSet(String input) throws IOException {
	//
	//		File file = new File(input);
	//		InputStreamReader insr = new InputStreamReader(
	//				new FileInputStream(file), "gb2312");
	//		BufferedReader br = new BufferedReader(insr);
	//		String line;
	//		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	//		List<Float> datas1 = new ArrayList<Float>();
	//		List<Float> datas2 = new ArrayList<Float>();
	//		int a = 1,aa = 1;
	//		while ((line = br.readLine()) != null) {
	//			// System.out.println(line);
	//			line = line.trim();
	//			if(line == "")break;
	//			if (line.trim().length() >= 1) {
	//				//System.out.println(line);					
	//				String[] strs = line.split("       ");
	//				datas1.add(Float.valueOf(strs[1]));
	//				datas2.add(Float.valueOf(strs[2]));				
	//			}else break;
	//
	//		}
	//		br.close();
	//		insr.close();
	//		List<Float> fdatas1 = formatdate(datas1);
	//		List<Float> fdatas2 = formatdate(datas2);
	//		for (float f : fdatas1) {
	//			dataset.addValue(f, "正解", "Y" + String.valueOf(a++));
	//			if(a==200)break;
	//		}
	//		for (float f : fdatas2) {
	//			dataset.addValue(f, "测解", "Y" + String.valueOf(aa++));
	//			if(aa==200)break;
	//		}
	//		return dataset;
	//	}
	// 返回柱图的数据集
	private static CategoryDataset getBarDataSet(String input) throws IOException {

		File file = new File(input);
		InputStreamReader insr = new InputStreamReader(
				new FileInputStream(file), "gb2312");
		BufferedReader br = new BufferedReader(insr);
		String line;
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		List<Float> datas = new ArrayList<Float>();
		int a = 1;
		while ((line = br.readLine()) != null) {
			line = line.trim();
			if(line.length() > 0) {
				for(int i = 0 ;i < 9; ++i)
				{
					int index = line.indexOf(" ");
					String temp = line.substring(0,index);
					datas.add(Float.valueOf(temp));
					line = line.substring(index+1,line.length()).trim();
				}
				datas.add(Float.valueOf(line)); 
			}
		}
		br.close();
		insr.close();
		List<Float> fdatas = formatdate(datas);
		for (float f : fdatas) {
			dataset.addValue(f, "R" + String.valueOf(a++), "");
		}
		return dataset;
	}
	//返回饼图的数据集
	private static DefaultPieDataset getPieDataSet(String input) throws IOException {

		File file = new File(input);
		InputStreamReader insr = new InputStreamReader(
				new FileInputStream(file), "gb2312"); //fix me, gb2312 is not good.
		BufferedReader br = new BufferedReader(insr);
		String line;
		DefaultPieDataset dataset = new DefaultPieDataset();
		int a = 1;
		while ((line = br.readLine()) != null) {
			line = line.trim();
			if (line.trim().length() >= 1) 
			{				 
				for(int i = 0 ;i < 9; ++i)
				{
					int index = line.indexOf(" ");
					String temp = line.substring(0,index);
					dataset.setValue("R" + String.valueOf(a++),Float.valueOf(temp));
					line = line.substring(index+1,line.length()).trim();
				}
				dataset.setValue("R" + String.valueOf(a++),Float.valueOf(line));	
			}
		}
		br.close();
		insr.close();
		return dataset;
	}
	//数据格式化
	private static List<Float> formatdate(List<Float> datas) {
		List<Float> result = new ArrayList<Float>();
		Float max = datas.get(0);
		Float min = datas.get(0);
		for (float f : datas) {
			if (f > max)
				max = f;
			if (f < min)
				min = f;
		}
		// System.out.println("max:"+max+"min:"+min);
		for (float f : datas) {
			result.add((f - min) / (max - min));
		}
		return result;
	}

	//public static void main(String[] args) throws IOException {
	public static void GetObj(String id,String filepath, int t) throws IOException {
		// 将生成的报表放到预览窗口中

		final ChartFrame preview ;
		switch(t){
		case 1: preview = new ChartFrame("结果图", generateLine(filepath));break;
		case 2: preview = new ChartFrame("结果图",generateBar(filepath));break;
		case 3: preview = new ChartFrame("结果图",generatePie(filepath));break;
		case 4: preview = new ChartFrame("结果图",generate2Line(filepath));break;
		case 5: preview = new ChartFrame("结果图",generate2Bar(filepath));break;
		default:preview = new ChartFrame("结果图",generate2Line(filepath));break;
		}

		preview.setName(id+"Gra");
		//		preview.addWindowListener(new WindowAdapter() {
		//			public void windowClosing(final WindowEvent event) {
		//				preview.dispose();
		//			}
		//		});
		//		preview.pack();
		// 调整预览窗口的大小和位置,适合屏幕，并且居中
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		preview.setSize(screenSize.width, screenSize.height - 50);// 适合屏幕，50表示把工具栏要考虑在内
		preview.setSize(600, 400);
		Dimension frameSize = preview.getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		preview.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height - 50) / 2);
		// 显示报表预览窗口
		preview.setVisible(true);
		//		LinuxClient.GetObj().getJTabbedPane().remove(pre);
		//		LinuxClient.GetObj().getJTabbedPane().addTab(id, preview);
		final String strid = id;
		//左键双击键关闭选中的选项卡
//		LinuxClient.GetObj().getJTabbedPane().addMouseListener(new MouseAdapter() {
//			public void mousePressed(MouseEvent e) {
//				if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {
//					if(LinuxClient.GetObj().getJTabbedPane().getTabCount() > 0) {
//						if(LinuxClient.GetObj().getJTabbedPane().getSelectedIndex() == LinuxClient.GetObj().getJTabbedPane().indexOfTab(strid)) {
//							LinuxClient.GetObj().getJTabbedPane().removeTabAt(LinuxClient.GetObj().getJTabbedPane().getSelectedIndex());
//							// System.out.println("选中的选项卡为:" + LinuxClient.GetObj().getJTabbedPane().getSelectedIndex());
//							// LinuxClient.GetObj().getJTabbedPane().getTabComponentAt(LinuxClient.GetObj().getJTabbedPane().getSelectedIndex()).repaint();
//							// LinuxClient.GetObj().getJTabbedPane().addTab(null,null);
//							//return;
//						}
//					}
//				}
//			}
//		});
//		pre=preview;
	}
//	private static ChartFrame pre=null;


	public static void main(String[] args) throws IOException{


		//将生成的报表放到预览窗口中

		final ChartFrame preview = new ChartFrame("分析",generate2Line("D:/SSH/cpp/Iterative Regression/Debug/out.txt"));

		preview.addWindowListener(new WindowAdapter() {

			public void windowClosing(final WindowEvent event) {

				preview.dispose();

			}

		});

		preview.pack();

		//调整预览窗口的大小和位置,适合屏幕，并且居中

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		preview.setSize(screenSize.width,screenSize.height-50);//适合屏幕，50表示把工具栏要考虑在内

		Dimension frameSize = preview.getSize();

		if (frameSize.height > screenSize.height) {

			frameSize.height = screenSize.height;

		}

		if (frameSize.width > screenSize.width) {

			frameSize.width = screenSize.width;

		}

		preview.setLocation( (screenSize.width - frameSize.width) / 2,

				(screenSize.height - frameSize.height-50) / 2);



		//显示报表预览窗口

		preview.setVisible(true);

	}
}
