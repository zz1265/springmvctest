package chart;

import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class MyJfreechartTest {

	/**  
	 * 获得数据集。
	 * @return  
	 */
	private static DefaultPieDataset getDataSet() {
		DefaultPieDataset dfp = new DefaultPieDataset();
		dfp.setValue("管理人员", 25);
		dfp.setValue("市场人员", 35);
		dfp.setValue("开发人员", 20);
		dfp.setValue("后勤人员", 5);
		dfp.setValue("财务人员", 15);
		return dfp;
	}

	/**  
	 * 生成饼状图。
	 */
	public static void makePieChart3D() {
		String title = "饼状图";
		// 获得数据集   
		DefaultPieDataset dataset = getDataSet();
		// 利用chart工厂创建一个jfreechart实例   
		// 方法说明见API   
		JFreeChart chart = ChartFactory.createPieChart3D(title, // 图表标题   
				dataset, // 数据集   
				true, // 是否显示图例   
				false, // 是否生成工具（提示）   
				false // 是否生成URL链接   
				);

		// 设置pieChart的标题与字体   
		Font font = new Font("宋体", Font.BOLD, 25);
		TextTitle textTitle = new TextTitle(title);
		textTitle.setFont(font);
		chart.setTitle(textTitle);

		chart.setTextAntiAlias(false);

		// 设置背景色   
		chart.setBackgroundPaint(new Color(199, 237, 204));

		// 设置图例字体   
		LegendTitle legend = chart.getLegend(0);
		legend.setItemFont(new Font("隶书", 1, 15));

		// 设置图标签字体   
		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setLabelFont(new Font("隶书", Font.TRUETYPE_FONT, 12));

		// 指定图片的透明度(0.0-1.0)   
		plot.setForegroundAlpha(0.65f);

		// 图片中显示百分比:自定义方式，{0} 表示选项， {1} 表示数值， {2} 表示所占比例 ,小数点后两位   
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
				"{0}={1}({2})", NumberFormat.getNumberInstance(),
				new DecimalFormat("0.00%")));

		// 图例显示百分比:自定义方式， {0} 表示选项， {1} 表示数值， {2} 表示所占比例   
		plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator(
				"{0} ({2})"));

		// 设置第一个 饼块section 的开始位置，默认是12点钟方向   
		plot.setStartAngle(90);

		/***********************************************************/
		ChartFrame frame = new ChartFrame(title, chart, true);
		frame.pack();
		frame.setVisible(true);
	}

	/**  
	 * 生成柱状图。
	 */
	public static void makeBarChart3D() {

		String title = "柱状图";

		// 获得数据集   
		CategoryDataset dataset = getDataset();

		JFreeChart chart = ChartFactory.createBarChart3D(title, // 图表标题   
				"水果", // 目录轴的显示标签   
				"销量", // 数值轴的显示标签   
				dataset, // 数据集   
				PlotOrientation.VERTICAL,// 图表方向：水平、垂直   
				true, // 是否显示图例   
				true, // 是否生成工具（提示）   
				true // 是否生成URL链接   
				);

		// 设置标题字体   
		Font font = new Font("宋体", Font.BOLD, 25);
		TextTitle textTitle = new TextTitle(title);
		textTitle.setFont(font);
		chart.setTitle(textTitle);

		chart.setTextAntiAlias(false);

		// 设置背景色   
		chart.setBackgroundPaint(new Color(199, 237, 204));

		// 设置图例字体   
		LegendTitle legend = chart.getLegend(0);
		legend.setItemFont(new Font("隶书", Font.TRUETYPE_FONT, 15));

		// 获得柱状图的Plot对象   
		CategoryPlot plot = chart.getCategoryPlot();

		// 取得横轴   
		CategoryAxis categoryAxis = plot.getDomainAxis();

		// 设置横轴显示标签的字体   
		categoryAxis.setLabelFont(new Font("宋体", Font.BOLD, 18));

		// 分类标签以45度角倾斜   
		categoryAxis.setTickLabelFont(new Font("隶书", Font.TRUETYPE_FONT, 18));

		// 取得纵轴   
		NumberAxis numberAxis = (NumberAxis) plot.getRangeAxis();

		// 设置纵轴显示标签的字体   
		numberAxis.setLabelFont(new Font("宋体", Font.BOLD, 18));

		/**************************************************************/
		ChartFrame frame = new ChartFrame(title, chart, true);
		frame.pack();
		frame.setVisible(true);
	}

	/**  
	 * 生成折线图。
	 */
	public static void makeLineAndShapeChart() {

		String title = "折线图";

		// 获得数据集   
		CategoryDataset dataset = getDataset();

		JFreeChart chart = ChartFactory.createLineChart(title, // 图表标题   
				"X轴", // 目录轴的显示标签   
				"Y轴", // 数值轴的显示标签   
				dataset, // 数据集   
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直   
				true, // 是否显示图例   
				true, // 是否生成工具（提示）   
				false // 是否生成URL链接   
				);

		chart.setTextAntiAlias(false);
		// 设置背景色   
		chart.setBackgroundPaint(Color.WHITE);

		// 设置图标题的字体重新设置title   
		Font font = new Font("隶书", Font.BOLD, 25);
		TextTitle textTitle = new TextTitle(title);
		textTitle.setFont(font);
		chart.setTitle(textTitle);

		// 设置面板字体   
		Font labelFont = new Font("宋体", Font.BOLD, 18);

		chart.setBackgroundPaint(Color.WHITE);

		// 设置图例字体   
		LegendTitle legend = chart.getLegend(0);
		legend.setItemFont(new Font("隶书", Font.TRUETYPE_FONT, 15));

		CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();

		// x轴 // 分类轴网格是否可见   
		categoryplot.setDomainGridlinesVisible(true);

		// y轴 //数据轴网格是否可见   
		categoryplot.setRangeGridlinesVisible(true);

		// 虚线色彩   
		categoryplot.setRangeGridlinePaint(Color.WHITE);

		// 虚线色彩   
		categoryplot.setDomainGridlinePaint(Color.WHITE);

		// 设置背景色   
		categoryplot.setBackgroundPaint(Color.lightGray);

		// 设置轴和面板之间的距离   
		// categoryplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));   

		CategoryAxis domainAxis = categoryplot.getDomainAxis();

		// 设置横轴标签标题字体   
		domainAxis.setLabelFont(labelFont);

		// 设置横轴数值标签字体   
		domainAxis.setTickLabelFont(new Font("隶书", Font.TRUETYPE_FONT, 15));

		// 横轴上的   
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.STANDARD);

		// Lable   
		// 45度倾斜   
		// 设置距离图片左端距离   
		domainAxis.setLowerMargin(0.0);
		// 设置距离图片右端距离   
		domainAxis.setUpperMargin(0.0);

		NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();

		// 设置纵轴显示标签的字体   
		numberaxis.setLabelFont(labelFont);

		numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		numberaxis.setAutoRangeIncludesZero(true);

		// 获得renderer 注意这里是下嗍造型到lineandshaperenderer！！   
		LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer) categoryplot
				.getRenderer();

		// series 点（即数据点）可见   
		lineandshaperenderer.setBaseShapesVisible(true);

		// series 点（即数据点）间有连线可见   
		lineandshaperenderer.setBaseLinesVisible(true);

		// 显示折点数据   
		// lineandshaperenderer.setBaseItemLabelGenerator(new   
		// StandardCategoryItemLabelGenerator());   
		// lineandshaperenderer.setBaseItemLabelsVisible(true);   

		/*******************************************************/
		ChartFrame frame = new ChartFrame(title, chart, true);
		frame.pack();
		frame.setVisible(true);

	}

	public static void makeTimeSeriesChart() {

		// 创建第一条时序线   
		TimeSeries pop1 = new TimeSeries("数据", Day.class);
		pop1.add(new Day(10, 1, 2004), 100);
		pop1.add(new Day(10, 2, 2004), 150);
		pop1.add(new Day(10, 3, 2004), 250);
		pop1.add(new Day(10, 4, 2004), 275);
		pop1.add(new Day(10, 5, 2004), 325);
		pop1.add(new Day(10, 6, 2004), 425);

		// 创建一个时序集合   
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(pop1);

		// 产生时序图   
		JFreeChart chart = ChartFactory.createTimeSeriesChart("人口统计时序图", "日期",
				"数据", dataset, true, true, false);

		String title = "人口统计时序图";

		// 设置图例字体   
		LegendTitle legend = chart.getLegend(0);
		legend.setItemFont(new Font("隶书", Font.TRUETYPE_FONT, 15));

		// 设置标题字体   
		Font font = new Font("隶书", Font.BOLD, 25);
		TextTitle textTitle = new TextTitle(title);
		textTitle.setFont(font);
		chart.setTitle(textTitle);

		// 设置日期显示格式   
		XYPlot plot = chart.getXYPlot();
		DateAxis axis = (DateAxis) plot.getDomainAxis();
		axis.setDateFormatOverride(new SimpleDateFormat("MM-dd-yyyy"));

		// 纵轴   
		NumberAxis numAxis = (NumberAxis) plot.getRangeAxis();

		// 设置纵轴标签字体   
		numAxis.setLabelFont(new Font("宋体", Font.BOLD, 14));

		// 横轴   
		DateAxis dateaxis = (DateAxis) plot.getDomainAxis();

		// 设置横轴标签字体   
		dateaxis.setLabelFont(new Font("宋体", Font.BOLD, 14));

		ChartFrame cf = new ChartFrame("时序图", chart);
		cf.pack();
		cf.setVisible(true);

	}

	/**  
	 * 获得数据集。
	 * @return  
	 */
	private static CategoryDataset getDataset() {
		double[][] data = new double[][] { { 672, 766, 223, 540, 126 },
				{ 325, 521, 210, 340, 106 }, { 332, 256, 523, 240, 526 } };
		String[] rowKeys = { "苹果", "梨子", "葡萄" };
		String[] columnKeys = { "北京", "上海", "广州", "成都", "深圳" };
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
				rowKeys, columnKeys, data);
		return dataset;
	}

	public static void main(String[] args) {

		// 3D饼状图   
		makePieChart3D();

		// 3D柱状图   
		makeBarChart3D();

		// 曲线图   
		makeLineAndShapeChart();

		// 时序图   
		makeTimeSeriesChart();
	}

}