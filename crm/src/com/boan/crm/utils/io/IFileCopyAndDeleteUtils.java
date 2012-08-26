package com.boan.crm.utils.io;

import java.io.File;
import java.io.IOException;

/**
 *
 */
public interface IFileCopyAndDeleteUtils
{
	/**
	 * 拷贝文件目录，从sourceFile目录源取得该源下所有文件子孙目录和文件拷贝到targetFile源
	 * @param sourceDirectory
	 * 源目录
	 * @param targetDirectory
	 * 输出目录
	 * @throws IOException
	 */
	public void copyDirectory( File sourceDirectory, File targetDirectory ) throws IOException;
	/**
	 * 拷贝文件目录，从sourceFile目录源取得该源下所有文件子孙目录和文件拷贝到targetFile源
	 * @param sourceDirectory
	 * 源目录
	 * @param targetDirectory
	 * 输出目录
	 * @param bufferSize
	 * 拷贝文件中利用缓存的大小，默认使用4096，代表4k
	 * @throws IOException
	 */
	public void copyDirectory( File sourceDirectory, File targetDirectory, int bufferSize ) throws IOException;
	/**
	 * 拷贝单一文件到指定的File对象中
	 * @param sourceFile
	 * 源文件的File对象
	 * @param targetFile
	 * 输出文件的File对象
	 * @throws IOException
	 */
	public void copySimpleFile( File sourceFile, File targetFile ) throws IOException;
	/**
	 * 拷贝单一文件到指定的File对象中
	 * @param sourceFile
	 * 源文件的File对象
	 * @param targetFile
	 * 输出文件的File对象
	 * @param bufferSize
	 * 拷贝文件中利用缓存的大小，默认使用4096，代表4k
	 * @throws IOException
	 */
	public void copySimpleFile( File sourceFile, File targetFile, int bufferSize ) throws IOException;
	/**
	 * 删除单一文件
	 * @param targetFile
	 * 欲被删除的文件File对象
	 * @throws IOException
	 */
	public void deleteSimpleFile( File targetFile ) throws IOException;
	/**
	 * 删除一个目录
	 * @param targetDirectory
	 * 欲被删除的目录File对象
	 * @throws IOException
	 */
	public void deleteDirectory( File targetDirectory ) throws IOException;
	/**
	 * 获取文件的尺寸，单位字节(byte)
	 * @param targetFile
	 * 目标获取的文件
	 * @return long
	 * 文件大小
	 */
	public long getFileSizeWithByteUnit( File targetFile );
	/**
	 * 拷贝单一文件到指定的目录
	 * @param sourceFile
	 * 源文件的File对象
	 * @param targetDirectory
	 * 输出文件的目录
	 * @throws IOException
	 */
	public void copySimpleFileToDirectory( File sourceFile, File targetDirectory ) throws IOException;
	/**
	 * 拷贝单一文件到指定的目录
	 * @param sourceFile
	 * 源文件的File对象
	 * @param targetDirectory
	 * 输出文件的目录
	 * @param bufferSize
	 * 拷贝文件中利用缓存的大小，默认使用4096，代表4k
	 * @throws IOException
	 */
	public void copySimpleFileToDirectory( File sourceFile, File targetDirectory, int bufferSize ) throws IOException;
	/**
	 * 剪切文件夹到指定的目录
	 * @param sourceDirectory
	 * 源文件夹的File对象
	 * @param targetDirectory
	 * 目标移动到的文件夹的File对象
	 */
	public void cutDirectoryToDirectory( File sourceDirectory, File targetDirectory ) throws IOException;
}