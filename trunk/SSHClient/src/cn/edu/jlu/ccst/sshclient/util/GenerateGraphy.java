package cn.edu.jlu.ccst.sshclient.util;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class GenerateGraphy {

	public GenerateGraphy() {
	}

	public static JFreeChart generateBar(String input) throws IOException{
		
		
		JFreeChart chart = ChartFactory.createBarChart3D("", // 图表标题
				"", // 目录轴的显示标签
				"", // 数值轴的显示标签
				getDataSet(input), // 数据集
				// PlotOrientation.HORIZONTAL , // 图表方向：水平
				PlotOrientation.VERTICAL, // 图表方向：垂直
				true, // 是否显示图例(对于简单的柱状图必须是false)
				false, // 是否生成工具
				false // 是否生成URL链接
				);

		// 重新设置图标标题，改变字体
		//chart.setTitle(new TextTitle("图书销量统计图", new Font("黑体", Font.ITALIC,22)));
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
		//categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
		categoryAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 18));
		// 取得纵轴
		NumberAxis numberAxis = (NumberAxis) plot.getRangeAxis();
		// 设置纵轴显示标签的字体
		numberAxis.setLabelFont(new Font("宋体", Font.BOLD, 22));

//		FileOutputStream fos = null;
//		fos = new FileOutputStream("book.jpg");
//		// 将统计图标输出成JPG文件
//		ChartUtilities.writeChartAsJPEG(fos, // 输出到哪个输出流
//				1, // JPEG图片的质量，0~1之间
//				chart, // 统计图标对象
//				800, // 宽
//				600,// 宽
//				null // ChartRenderingInfo 信息
//				);
//		fos.close();
		return chart;
	}

	// 返回一个CategoryDataset实例
	private static CategoryDataset getDataSet(String input) throws IOException{
		
		File file = new File(input);
		InputStreamReader insr = new InputStreamReader(new FileInputStream(file),"gb2312");
		BufferedReader br = new BufferedReader(insr);
		String line;
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		List<Float> datas = new ArrayList();
		int a = 1;
		while ((line = br.readLine()) != null) {
			//System.out.println(line);
			if(line.trim().length()>=1)
				datas.add(Float.valueOf(line));
		}
        br.close();
        insr.close();
        List<Float> fdatas = formatdate(datas);
        for(float f : fdatas){
        	dataset.addValue(f, "R"+String.valueOf(a++), "");
        }
		return dataset;
	}
	
	public static List<Float> formatdate(List<Float> datas){
		List<Float> result = new ArrayList();
		Float max = datas.get(0);
		Float min = datas.get(0);
		for(float f:datas){
			if(f>max)max = f;
			if(f<min)min = f;
		}
		//System.out.println("max:"+max+"min:"+min);
		for(float f:datas){
			result.add((f-min)/(max-min));
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {

		

		
		// 将生成的报表放到预览窗口中
        
		final ChartFrame preview = new ChartFrame("TEST", generateBar("e:/ssh/test.txt"));
		preview.addWindowListener(new WindowAdapter() {
			public void windowClosing(final WindowEvent event) {
				preview.dispose();
			}
		});
		preview.pack();
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
	}
}
