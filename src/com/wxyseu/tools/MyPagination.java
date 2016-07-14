package com.wxyseu.tools;

import java.util.ArrayList;
import java.util.List;

import com.wxyseu.model.Diary;

public class MyPagination<T> {
	public List<T> list = null;
	private int recordCount = 0;  // �����¼�����ı��� 
	private int pageSize = 0;  // ����ÿҳ��ʾ�ļ�¼���ı���
	private int maxPage = 0;  // �������ҳ���ı���
	
	public List<T> getInitPage(List<T> list,int Page,int pageSize)
	{
		List<T> newList = new ArrayList<T>();
		this.list = list;
		recordCount = list.size();	// list���ϵ�Ԫ�ظ���
		this.pageSize = pageSize;
		this.maxPage = getMaxPage();
		
		try {
			for (int i = (Page-1)*pageSize; i <= Page*pageSize-1; i++) {
				try{
					if(i>=recordCount)
					{
						break;
					}
				}catch(Exception e){}
				newList.add((T)list.get(i));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return newList;
	}
	public List<T> getAppointPage(int Page)
	{
		List<T> newList = new ArrayList<T>();
		try {
			for (int i = (Page-1)*pageSize; i <=Page*pageSize; i++) {
				try {
					if (i>=recordCount) {
						break;
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				newList.add((T)list.get(i));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return newList;
	}
	
	public int getMaxPage() {
		int maxPage = (recordCount%pageSize==0)?(recordCount/pageSize):(recordCount/pageSize+1);
		return maxPage;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public int getPage(String str)
	{
		if(str==null)
			str="0";
		int Page = Integer.parseInt(str);
		if(Page<1)
		{
			Page=1;
		}
		else{
			if((Page-1)*pageSize+1>recordCount)
				Page = maxPage;
		}
		
		return Page;
	}
	public String printCtrl(int Page,String url,String para)
	{
		String strHTML="<table width='100%' border='0' cellspacing='0' cellpadding='0'>"
				+ "<tr><td height='24' align='right'>��ǰҳ������"+Page+"/"+maxPage+"��&nbsp;";
		try {
			if(Page>1)
			{
				strHTML=strHTML+"<a href='"+url+"&Page=1"+para+"'>��һҳ</a> ";
				strHTML=strHTML+"<a href='"+url+"&Page="+(Page-1)+para+"'>��һҳ</a>";
			}
			if(Page<maxPage)
			{
				strHTML=strHTML+"<a href='"+url+"&Page="+(Page+1)+para+"'>��һҳ</a> "
						+"<a href='"+url+"&Page="+maxPage+para+"'>���һҳ&nbsp;</a>";
			}
			strHTML=strHTML+"</td></tr>    </table>";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return strHTML;
	}
}

