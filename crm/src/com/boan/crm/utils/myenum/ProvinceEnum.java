package com.boan.crm.utils.myenum;

/**
 * @author YF
 *
 */
public enum  ProvinceEnum {
	/**
	 * 安徽
	 */
	AnHui("AnHui","安徽"),
	/**
	 * 澳门
	 */
	AoMen("AoMen","澳门"),
	/**
	 * 北京
	 */
	BeiJing("BeiJing","北京"),
	/**
	 * 重庆
	 */
	ChongQing("ChongQing","重庆"),
	/**
	 * 福建
	 */
	FuJian("FuJian","福建"),
	/**
	 * 安徽
	 */
	GanSu("GanSu","甘肃"),
	/**
	 * 安徽
	 */
	GuangDong("GuangDong","广东"),
	/**
	 * 安徽
	 */
	GuangXi("GuangXi","广西"),
	/**
	 * 贵州
	 */
	GuiZhou("GuiZhou","贵州"),
	/**
	 * 海南
	 */
	HaiNan("HaiNan","海南"),
	/**
	 * 河北
	 */
	HeBei("HeBei","河北"),
	/**
	 * 黑龙江
	 */
	HeiLongJiang("HeiLongJiang","黑龙江"),
	/**
	 * 河南
	 */
	HeNan("HeNan","河南"),
	/**
	 * 安徽
	 */
	HuBei("HuBei","湖北"),
	/**
	 * 安徽
	 */
	HuNan("HuNan","湖南"),
	/**
	 * 安徽
	 */
	JiangSu("JiangSu","江苏"),
	/**
	 * 江西
	 */
	JiangXi("JiangXi","江西"),
	/**
	 * 吉林
	 */
	JiLin("JiLin","吉林"),
	/**
	 * 辽宁
	 */
	LiaoNing("LiaoNing","辽宁"),
	/**
	 * 内蒙
	 */
	NeiMeng("NeiMeng","内蒙"),
	/**
	 * 宁夏
	 */
	NingXia("NingXia","宁夏"),
	/**
	 * 青海
	 */
	QingHai("QingHai","青海"),
	/**
	 * 山东
	 */
	ShanDong("ShanDong","山东"),
	/**
	 * 上海
	 */
	ShangHai("ShangHai","上海"),
	/**
	 * 山西
	 */
	ShanXi("ShanXi","山西"),
	/**
	 * 陕西
	 */
	ShanXi2("ShanXi2","陕西"),
	/**
	 * 四川
	 */
	SiChuan("SiChuan","四川"),
	/**
	 * 台湾
	 */
	TaiWan("TaiWan","台湾"),
	/**
	 * 安徽
	 */
	TianJin("TianJin","天津"),
	/**
	 * 香港
	 */
	XiangGang("XiangGang","香港"),
	/**
	 * 新疆
	 */
	XinJiang("XinJiang","新疆"),
	/**
	 * 西藏
	 */
	XiZang("XiZang","西藏"),
	/**
	 * 云南
	 */
	YunNan("YunNan","云南"),
	/**
	 * 浙江
	 */
	ZheJiang("ZheJiang","浙江");
	
	protected String key;  
	
	protected String name;  
	
	private ProvinceEnum(String key,String name){
		this.key= key;
		this.name= name;
	}
	
	/**
	 * @return 省份名称
	 */
	public  String getName(){
		return name;
	}
	
	/**
	 * @return 省份拼音
	 */
	public String getKey(){
		return key;
	}
	
	/**
	 * 根据省份拼音获取省份名称
	 * @param key 拼音
	 * @return  名称
	 */
	public static String getNameByKey(String key){
		String name=null;
		for(ProvinceEnum item : ProvinceEnum.values()){  
			if(item.toString().equals(key))  {
				name = item.getName();
				break;
			}
		}
		return name;
	}
	
	/**
	 * 根据省份名称获取省份拼音
	 * @param name 名称
	 * @return  拼音
	 */
	public static String getKeyByName(String name){
		String key=null;
		for(ProvinceEnum item : ProvinceEnum.values()){  
			if(item.getName().equals(name))  {
				key = item.getKey();
				break;
			}
		}
		return key;
	}
}
