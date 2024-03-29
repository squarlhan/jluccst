package cn.edu.jlu.ccst.sshclient.util;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
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

import javax.swing.JTable;
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
import cn.edu.jlu.ccst.sshclient.ui.ResultUI;

public class GenerateGraphy2 {
	public GenerateGraphy2() {
	}
	/**
	 * 生成饼图
	 * @param input
	 * @return
	 * @throws IOException
	 */
	public static JFreeChart generatePie2(List list) throws IOException {

		JFreeChart chart = ChartFactory.createPieChart3D("", // 图表标题
				getPieDataSet2(list), // 数据集
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
	public static JFreeChart generateLine2(List<List<Float>> lsls) throws IOException {

		JFreeChart chart = ChartFactory.createLineChart("", // 图表标题
				"", // 目录轴的显示标签
				"", // 数值轴的显示标签
				getLineDataSet2(lsls), // 数据集
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
	public static JFreeChart generateBar2(List<List<Float>> lsls) throws IOException {

		JFreeChart chart = ChartFactory.createBarChart3D("", // 图表标题
				"", // 目录轴的显示标签
				"", // 数值轴的显示标签
				getBarDataSet2(lsls), // 数据集
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
	/*
	 * 复制
	 */
	public static JFreeChart generate2Line2(List<List<Float>> lsls,int[] selectcol) throws IOException {
		JFreeChart chart = ChartFactory.createLineChart("", // 图表标题
				"", // 目录轴的显示标签
				"", // 数值轴的显示标签
				get2LineDataSet2( lsls,selectcol ), // 数据集
				// PlotOrientation.HORIZONTAL , // 图表方向：水平
				PlotOrientation.VERTICAL, // 图表方向：垂直
				true, // 是否显示图例(对于简单的柱状图必须是false)
				false, // 是否生成工具
				false // 是否生成URL链接
		);
		LegendTitle legend = chart.getLegend(0);
		legend.setItemFont(new Font("宋体", Font.BOLD, 14));
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		CategoryAxis categoryAxis = plot.getDomainAxis();
		categoryAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 18));
		NumberAxis numberAxis = (NumberAxis) plot.getRangeAxis();
		numberAxis.setLabelFont(new Font("宋体", Font.BOLD, 22));
		return chart;
	}
	public static JFreeChart generate2Bar2(List<List<Float>> lsls,int[] selectcol) throws IOException {

		JFreeChart chart = ChartFactory.createBarChart("", // 图表标题
				"", // 目录轴的显示标签
				"", // 数值轴的显示标签
				get2LineDataSet2(lsls,selectcol), // 数据集
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
	private static CategoryDataset getLineDataSet2(List<List<Float>> lsls) throws IOException {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		List<Float> datas = new ArrayList<Float>();
		int a = 1;
		for (int k = 0; k < lsls.size(); k++) {
			for (float f : lsls.get(k)) {
				dataset.addValue(f, "", "R"+k + String.valueOf(a++));
//				dataset.addValue(f, "", thiscolname[k]+"R"+k + String.valueOf(a++));
//				System.out.println("----------*****************--------------");
				if (a == 200){a=1;
					break;}
			}
		}
		return dataset;
	}
	// 返回柱图的数据集
	private static CategoryDataset getBarDataSet2(List<List<Float>> lsls) throws IOException {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		int a = 1;
		for (int k = 0; k < lsls.size(); k++) {
			for (float f : lsls.get(k)) {
				dataset.addValue(f, "R"+k + String.valueOf(a++), "");
				if (a == 200){a=1;
					break;}
			}
		}
		return dataset;
	}
	//返回饼图的数据集
	private static DefaultPieDataset getPieDataSet2(List list) throws IOException {

		DefaultPieDataset dataset = new DefaultPieDataset();
		int a = 1;
		for(int i=0;i<list.size();i++){
			dataset.setValue("R" + String.valueOf(a++),(Float)list.get(i));
		if(i==10)
			break;
		}
//		dataset.setValue("R" + String.valueOf(a++),Float.valueOf(line));
		return dataset;
	}
	private static CategoryDataset get2LineDataSet2(List<List<Float>> lsls,int[] selectcol) throws IOException {
//		String selectstr[]=new String[selectcol.length];
//		for(int i=0;i<selectcol.length;i++){
//			selectstr[i]=String.valueOf(selectcol[i]);
//		}
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		int aa = 1;
		for (int k = 0; k < lsls.size(); k++) {
//			int selectedlines = ptable.getSelectedColumns()[k];
//			String thiscolname = ResultUI.colname[selectedlines].toString();
			for (float f : lsls.get(k)) {
//				System.out.println("length "+selectcol.length);
//				dataset.addValue(f, "测解"+k, "Y" + String.valueOf(aa++));
				dataset.addValue(f, "col_"+(selectcol[k]+1), "Y" + String.valueOf(aa++));
//				dataset.addValue(f, thiscolname, "Y" + String.valueOf(aa++));
				if (aa == 200){aa=1;
					break;}
			}
		}
		return dataset;
	}
	public static void GetObj2(List<List<Float>> lsls,int t ,int[] selectcol) throws IOException {
		// 将生成的报表放到预览窗口中
		final ChartFrame preview ;
		switch(t){
		case 1: preview = new ChartFrame("Graph", generateLine2(lsls));break;
		case 2: preview = new ChartFrame("Graph",generateBar2(lsls));break;
		case 3: preview = new ChartFrame("Graph",generatePie2(lsls.get(0)));break;
		case 4: preview = new ChartFrame("Graph",generate2Bar2(lsls,selectcol));break;
		default: preview = new ChartFrame("Graph",generate2Line2(lsls,selectcol));
		}
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage((new GenerateGraphy2()).getClass().getResource(
					"/cn/edu/jlu/ccst/sshclient/ui/resource/tubiao.png"));
		preview.setIconImage(img);
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
		pre=preview;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	private static ChartFrame pre=null;


	public static void main(String[] args) throws IOException{


		//将生成的报表放到预览窗口中

//		final ChartFrame preview = new ChartFrame("分析",generate2Line2("D:/SSH/cpp/Iterative Regression/Debug/out.txt"));
//
//		preview.addWindowListener(new WindowAdapter() {
//
//			public void windowClosing(final WindowEvent event) {
//
//				preview.dispose();
//
//			}
//
//		});
//
//		preview.pack();
//
//		//调整预览窗口的大小和位置,适合屏幕，并且居中
//
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//
//		preview.setSize(screenSize.width,screenSize.height-50);//适合屏幕，50表示把工具栏要考虑在内
//
//		Dimension frameSize = preview.getSize();
//
//		if (frameSize.height > screenSize.height) {
//
//			frameSize.height = screenSize.height;
//
//		}
//
//		if (frameSize.width > screenSize.width) {
//
//			frameSize.width = screenSize.width;
//
//		}
//
//		preview.setLocation( (screenSize.width - frameSize.width) / 2,
//
//				(screenSize.height - frameSize.height-50) / 2);
//
//
//
//		//显示报表预览窗口
//
//		preview.setVisible(true);

	}
}
