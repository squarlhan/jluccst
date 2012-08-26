package com.boan.crm.utils.io.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.boan.crm.utils.io.IFileCopyAndDeleteUtils;

/**
 * 实现文件的拷贝删除的工具类
 * @version 1.0.0
 */
public class FileCopyAndDeleteUtilsAdaptor implements IFileCopyAndDeleteUtils
{

	/**
	 * 将一个目录下的所有子集文件及文件夹拷贝到另外一个文件夹下
	 * @param sourceDirectory
	 * 源目录的File对象
	 * @param targetDirectory
	 * 目标目录的File对象，若该目录不存在，方法自动创建该目录存储结构
	 * @pararm bufferSize
	 * 拷贝缓存
	 */
	@Override
	public void copyDirectory( File sourceDirectory, File targetDirectory ) throws IOException
	{
		copyDirectory( sourceDirectory, targetDirectory, 4096 );
	}
	/**
	 * 将一个目录下的所有子集文件及文件夹拷贝到另外一个文件夹下
	 * @param sourceDirectory
	 * 源目录的File对象
	 * @param targetDirectory
	 * 目标目录的File对象，若该目录不存在，方法自动创建该目录存储结构
	 * @pararm bufferSize
	 * 拷贝缓存
	 */
	@Override
	public void copyDirectory( File sourceDirectory, File targetDirectory, int bufferSize ) throws IOException
	{
		if( sourceDirectory != null && sourceDirectory.exists() )
		{
			if( !targetDirectory.exists() )
				targetDirectory.mkdirs();
			recurCopyingDirectory( sourceDirectory, targetDirectory, bufferSize );
		}
	}
	/**
	 * 拷贝文件到指定的新位置上
	 * @param sourceFile
	 * 源文件的File对象
	 * @param targetFile
	 * 新文件的File对象
	 */
	@Override
	public void copySimpleFile( File sourceFile, File targetFile ) throws IOException
	{
		copySimpleFile( sourceFile, targetFile, 4096 );
	}
	/**
	 * 拷贝文件到指定的新位置上
	 * @param sourceFile
	 * 源文件的File对象
	 * @param targetFile
	 * 新文件的File对象
	 * @param bufferSize
	 * 缓冲大小
	 */
	@Override
	public void copySimpleFile( File sourceFile, File targetFile, int bufferSize ) throws IOException
	{
		copyFile( sourceFile, targetFile, bufferSize );
	}
	/**
	 * 拷贝文件到目录
	 * @param sourceFile
	 * File指定文件，非目录
	 * @param targetDirectory
	 * File指定目录，非文件
	 */
	@Override
	public void copySimpleFileToDirectory( File sourceFile, File targetDirectory ) throws IOException
	{
		copyFileToDirectory( sourceFile, targetDirectory, 4096 );
	}
	/**
	 * 拷贝文件到目录
	 * @param sourceFile
	 * File指定文件，非目录
	 * @param targetDirectory
	 * File指定目录，非文件
	 * @param bufferSize
	 * 拷贝缓存
	 */
	@Override
	public void copySimpleFileToDirectory( File sourceFile, File targetDirectory, int bufferSize ) throws IOException
	{
		copyFileToDirectory( sourceFile, targetDirectory, bufferSize );
	}
	/**
	 * 剪切文件夹到指定的目录
	 * @param sourceDirectory
	 * 源文件夹的File对象
	 * @param targetDirectory
	 * 目标移动到的文件夹的File对象
	 */
	@Override
	public void cutDirectoryToDirectory( File sourceDirectory, File targetDirectory ) throws IOException
	{
		copyDirectory( sourceDirectory, targetDirectory );
		deleteDirectory( sourceDirectory );
	}
	/**
	 * 删除文件
	 * @param targetFile
	 * File指定文件
	 */
	@Override
	public void deleteSimpleFile( File targetFile ) throws IOException
	{
		deleteFile( targetFile );
	}
	/**
	 * 删除指定的目录
	 * @param targetDirectory
	 * File指定目录
	 */
	@Override
	public void deleteDirectory( File targetDirectory ) throws IOException
	{
		recurDeleteDirectory( targetDirectory );
	}
	/**
	 * 将表示文件绝对路径的字符串数组转换为File对象数组
	 * 此方法返回结果会过滤掉路径中的不存在的文件
	 * @param paths
	 * 文件绝对路径的字符串数组
	 * @return File[]
	 */
	public static File[] convertFilePath( String[] paths )
	{
		File[] result = null;
		if( paths != null && paths.length > 0 )
		{
			List<File> list = new ArrayList<File>( paths.length );
			File tmpFile = null;
			for( String path : paths )
			{
				if( StringUtils.isNotBlank( path ) )
				{
					tmpFile = new File( path );
					if( tmpFile.exists() )
						list.add( tmpFile );
				}
			}
			int listSize = list.size();
			if( listSize > 0 )
			{
				result = new File[listSize];
				for( int i = 0; i < listSize; i++ )
				{
					result[i] = list.get( i );
				}
			}
		}
		return result;
	}
	/**
	 * 获取指定文件的存储尺寸
	 * @param targetFile
	 * File指定的文件，非目录
	 */
	@Override
	public long getFileSizeWithByteUnit( File targetFile )
	{
		if( targetFile != null && targetFile.exists() )
			return targetFile.length();
		return 0;
	}
	/**
	 * 删除指定的文件
	 * @param targetFile
	 * File指定的文件，非目录
	 * @throws IOException
	 */
	private void deleteFile( File targetFile ) throws IOException
	{
		if( targetFile != null && targetFile.exists() )
		{
			targetFile.delete();
		}
	}
	/**
	 * 递归删除删除指定的目录下文件
	 * @param targetDirectory
	 * File指定的目录，非文件
	 * @throws IOException
	 */
	private void recurDeleteDirectory( File targetDirectory ) throws IOException
	{
		if( targetDirectory.exists() && targetDirectory.isDirectory() )
		{
			File[] childrenFiles = targetDirectory.listFiles();
			if( childrenFiles != null && childrenFiles.length > 0 )
			{
				for( File child : childrenFiles )
				{
					if( child.isFile() )
					{
						deleteFile( child );
					}
					else if( child.isDirectory() )
					{
						recurDeleteDirectory( child );
					}
					child.delete();
				}
			}
		}
		targetDirectory.delete();
	}
	/**
	 * 拷贝文件到指定的新位置上
	 * @param sourceFile
	 * 源文件的File对象
	 * @param targetFile
	 * 新文件的File对象
	 * @param bufferSize
	 * 缓冲大小
	 * @throws IOException
	 */
	private void copyFile( File sourceFile, File targetFile, int bufferSize ) throws IOException
	{
		if( sourceFile != null && sourceFile.exists() && targetFile != null )
		{
			if( !targetFile.getParentFile().exists() || !targetFile.getParentFile().isDirectory() )
				targetFile.getParentFile().mkdirs();
			if( !targetFile.exists() )
				targetFile.createNewFile();
			BufferedInputStream bis = new BufferedInputStream( new FileInputStream( sourceFile ) );
			BufferedOutputStream bos = new BufferedOutputStream( new FileOutputStream( targetFile ) );
			byte[] buff = new byte[bufferSize];
			int c = -1;
			while( ( c = bis.read( buff ) ) != -1 )
			{
				bos.write( buff, 0, c );
			}
			bos.flush();
			bos.close();
			bis.close();
		}
	}
	/**
	 * 拷贝文件到指定的目录
	 * @param sourceFile
	 * 源文件的File对象
	 * @param targetDirectory
	 * 目标目录的File对象
	 * @param bufferSize
	 * 缓冲大小
	 * @throws IOException
	 */
	private void copyFileToDirectory( File sourceFile, File targetDirectory, int bufferSize ) throws IOException
	{
		if( sourceFile != null && sourceFile.exists() && targetDirectory != null )
		{
			if( !targetDirectory.exists() )
				targetDirectory.mkdirs();
			File targetFile = new File( targetDirectory.getAbsolutePath() + "/" + sourceFile.getName() );
			BufferedInputStream bis = new BufferedInputStream( new FileInputStream( sourceFile ) );
			BufferedOutputStream bos = new BufferedOutputStream( new FileOutputStream( targetFile ) );
			byte[] buff = new byte[bufferSize];
			int c = -1;
			while( ( c = bis.read( buff ) ) != -1 )
			{
				bos.write( buff, 0, c );
			}
			bos.flush();
			bos.close();
			bis.close();
		}
	}
	/**
	 * 递归拷贝指定的目录或文件
	 * @param sourceFile
	 * 代表文件或目录的拷贝源
	 * @param targetFile
	 * 代表文件或目录的目标
	 * @param bufferSize
	 * 拷贝缓冲
	 * @throws IOException
	 */
	private void recurCopyingDirectory( File sourceFile, File targetFile, int bufferSize ) throws IOException
	{
		if( sourceFile.exists() )
		{
			if( sourceFile.isFile() )
			{
				copyFile( sourceFile, targetFile, bufferSize );
			}
			else if( sourceFile.isDirectory() )
			{
				File[] childrenFiles = sourceFile.listFiles(new FileFilter(){
					public boolean accept( File f ){
						/*String filePath = f.getAbsolutePath();
						int partStrIndex = filePath.lastIndexOf( ".part" );
						if( partStrIndex != -1 )
						{
							return true;
						}*/
						if( f.isHidden() )
							return false;
						return true;
					}
				});
				if( childrenFiles.length > 0 )
				{
					File tmpFile = null;
					for( File child : childrenFiles )
					{
						tmpFile = new File( targetFile.getCanonicalFile() + System.getProperty( "file.separator" ) + child.getName() );
						if( child.isDirectory() )
						{
							if( !tmpFile.exists() )
								tmpFile.mkdirs();							
							recurCopyingDirectory( child, tmpFile, bufferSize );
						}
						else if( child.isFile() )
						{
							copyFile( child, tmpFile, bufferSize );
						}
					}
				}
			}
		}
	}

	public static void main( String[] args ) throws Exception
	{
		FileCopyAndDeleteUtilsAdaptor instance = new FileCopyAndDeleteUtilsAdaptor();
		/*File f = new File( "d:/电子证书" );
		FileAttribute fa = new FileAttribute();
		System.out.println( fa.getFileSize() );*/
		File aFile = new File( "d:/1.gif" );
		File bFile = new File( "d:/3.gif" );
		instance.copyFileToDirectory( aFile, bFile, 4096 );
		//long t1 = System.currentTimeMillis();
		//instance.deleteDirectory( new File( "/home/hhh/fuck" ) );
		//long t2 = System.currentTimeMillis();
		//删除720Mb文件杂项花费：13.359秒
		//System.out.println( "删除720Mb文件杂项花费：" + ( t2 - t1 )/1000+ "." + (t2 - t1)%1000  + "秒" );
//		instance.deleteSimpleFile( new File( "/home/hhh/n044.xml" ) );
//		instance.copyFileToDirectory( new File( "/home/hhh/500万数据分页－oracle.html" ), new File( "/home/hhh/fuck" ), 4096 );
//		String[] files = new String[3];
//		files[0] = "/home/hhh/aa.xml";
//		files[1] = "/home/hhh/aaa.xml";
//		files[2] = "/home/hhh/test2.odt";
//		File[] result = instance.convertFilePath( files );
//		for( File cFile : result )
//		{
//			System.out.println( cFile.getName() );
//		}
//		instance.cutDirectoryToDirectory( new File( "c:/测试/ATI" ), new File( "c:/测试/ati2" ) );
		/*File d1 = new File( "C:\\测试\\40288fd830d90c2b0130d9db12be0001q\\A" );
		File d2 = new File( "C:\\测试\\40288fd830d90c2b0130d9dc2c930002\\张光辉\\A" );
		instance.copyDirectory( d1, d2 );*/
	}
}
