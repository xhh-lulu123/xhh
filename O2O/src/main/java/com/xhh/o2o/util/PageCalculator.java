package com.xhh.o2o.util;

public class PageCalculator {
	/**
	 *从第几页的数量，转换成从第几行取的数量
	 * @param pageIndex 第几页
	 * @param pageSize  数量
	 * @return
	 */
	public static int calculateRowIndex(int pageIndex, int pageSize) {
		return (pageIndex > 0) ? (pageIndex - 1) * pageSize : 0;
	}

}
