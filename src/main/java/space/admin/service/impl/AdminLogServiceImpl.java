package space.admin.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import space.admin.service.AdminLogService;
import space.admin.vo.Page;

@Service("adminLogService")
@Transactional
public class AdminLogServiceImpl implements AdminLogService {

	@Override
	public int getTotalNumber(String retrieval, List<String> fileList) {
		int totalNumber = 0;
		Iterator<String> iterator = fileList.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			if (next.contains(retrieval)) {
				totalNumber++;
			}
		}
		return totalNumber;
	}

	@Override
	public List<String> list(String retrieval, Page page, List<String> fileList) {
		List<String> list = new ArrayList<String>();
		int current = 1, totalNumber = 0;
		Iterator<String> iterator = fileList.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			if (current >= page.getStartIndex() && totalNumber < page.getPageSize()) {
				list.add(next);
				totalNumber++;
			}
			current++;
		}
		return list;
	}

	/**
	 * 获取该目录下的所有文件名
	 * 
	 * @param path
	 *            该文件目录下没有子目录
	 * @return
	 */
	public List<String> getFileList(String path, int type) {
		// 1.获取所有文件名
		String[] fileList = null;
		File rootDir = new File(path);
		if (rootDir.isDirectory()) {
			fileList = rootDir.list();
		}
		String retrieval = "";
		if (type == 0) {
			// 普通日志
			retrieval = "log.log";
		} else {
			// 错误日志
			retrieval = "error";
		}
		int count = 1;
		List<String> list = new ArrayList<String>();
		while (count <= fileList.length) {
			if (fileList[count - 1].contains(retrieval)) {
				list.add(fileList[count - 1]);
			}
			count++;
		}
		return list;
	}

}
