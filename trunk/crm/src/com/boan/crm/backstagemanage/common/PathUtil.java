package com.boan.crm.backstagemanage.common;

import java.io.File;
import java.net.URL;

import org.aspectj.util.FileUtil;

/**
 * 获取工程目录类
 * 
 * @author XXX
 * @version 1.0.0
 */
public class PathUtil {
	private static PathUtil instance = null;

	private PathUtil() {

	}

	public static PathUtil getInstance() {
		if (instance == null) {
			instance = new PathUtil();
		}
		return instance;
	}

	/**
	 * 获取当前文件路径
	 * 
	 * @return
	 */
	public String getWebClassesPath() {
		String path = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
		return path;
	}

	/**
	 * 获取当前工程的web-inf路径
	 * 
	 * @return
	 * @throws IllegalAccessException
	 */
	public String getWebInfPath() throws IllegalAccessException {
		String path = getWebClassesPath();
		if (path.indexOf("WEB-INF") > 0) {
			path = path.substring(0, path.indexOf("WEB-INF") + 8);
		} else {
			throw new IllegalAccessException("路径获取错误");
		}
		return path;
	}

	/**
	 * 获取当前工程路径
	 * 
	 * @return
	 * @throws IllegalAccessException
	 */
	public String getWebRoot() throws IllegalAccessException {
		String path = getWebClassesPath();
		if (path.indexOf("WEB-INF") > 0) {
			path = path.substring(0, path.indexOf("WEB-INF/"));
		} else {
			throw new IllegalAccessException("路径获取错误");
		}
		return path;
	}

	/**
	 * 获取调用该访问的jar包或类的名称
	 * 
	 * @return
	 * @throws IllegalAccessException
	 */
	public String getJarName(String classFilePath) throws IllegalAccessException {
		// "/D:/apache-tomcat-6.0.29/webapps/cbit-csms/WEB-INF/lib/cbit-bundle-csms-utils_1.0.0.jar"
		// String path = getWebClassesPath();
		String path = classFilePath;
		if (path.indexOf("WEB-INF/") > 0) {
			// 可能是class
			if (path.indexOf(".jar") > 0) {
				path = path.substring(path.indexOf("WEB-INF/") + "WEB-INF/lib/".length(), path.indexOf(".jar"));
			} else if (path.indexOf(".class") > 0) {
				path = path.substring(path.lastIndexOf("/") + 1, path.indexOf(".class") + 6);
			}
			// 可能是jar
		} else {
			throw new IllegalAccessException("路径获取错误");
		}
		return path;
	}

	/**
	 * 获取工程名称，如：/cbit-csms
	 * 
	 * @return
	 * @throws IllegalAccessException
	 */
	public String getContextPath() throws IllegalAccessException {
		String path = getWebClassesPath();
		if (path.indexOf("WEB-INF") > 0) {
			path = path.substring(0, path.indexOf("WEB-INF/") - 1);
			path = path.substring(path.lastIndexOf(("/"), path.length()));
		} else {
			throw new IllegalAccessException("路径获取错误");
		}
		return path;
	}

	private static String getDirFromClassLoader() {
		try {
			String path = FileUtil.class.getName().replace(".", "/");
			path = "/" + path + ".class";
			URL url = FileUtil.class.getResource(path);
			String jarUrl = url.getPath();
			if (jarUrl.startsWith("file:")) {
				if (jarUrl.length() > 5) {
					jarUrl = jarUrl.substring(5);
				}
				jarUrl = jarUrl.split("!")[0];

			} else {
				jarUrl = FileUtil.class.getResource("/").toString().substring(5);
			}
			File file = new File(jarUrl);
			return file.getParent();

		} catch (Exception e) {
		}
		return null;
	}

	public static String getJarDir() {
		String path = getDirFromClassLoader();
		if (path == null) {
			path = System.getProperty("user.dir");
		}
		return path;
	}

	public static void main(String[] args) throws Exception {
		// PathUtil p = new PathUtil();
		// System.out.println( p.getWebClassesPath() );
		// System.out.println( p.getWebInfPath() );
		// System.out.println( p.getWebRoot() );
		// System.out.println( PathUtil.getJarDir() );
		String path =PathUtil.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		//String path = System.getProperty("java.class.path");
		//int firstIndex = path.lastIndexOf(System.getProperty("path.separator")) + 1;
		//int lastIndex = path.lastIndexOf(File.separator) + 1;
		//path = path.substring(firstIndex, lastIndex);
		System.out.println(path);
	}
}