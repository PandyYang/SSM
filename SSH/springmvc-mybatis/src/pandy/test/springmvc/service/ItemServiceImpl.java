package pandy.test.springmvc.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pandy.test.springmvc.dao.ItemsMapper;
import pandy.test.springmvc.pojo.Items;

@Service
public class ItemServiceImpl implements ItemService {
	//查询商品列表
	@Autowired
	private ItemsMapper itemsMapper;
	public List<Items> selectItemsList(){
		return itemsMapper.selectByExampleWithBLOBs(null);
	}
	@Override
	public Items selectItemsById(Integer id) {
		// TODO Auto-generated method stub
		return itemsMapper.selectByPrimaryKey(id);
	}
	@Override
	public void updateItemsById(Items items) {
		// TODO Auto-generated method stub
		//设置数据库中的商品创建时间为当前的默认时间
		//默认图片的选项可以在dao层的源码中进行非空判断
		items.setCreatetime(new Date());
		//分析源代码见到此方法中没有进行if else进行非空判断
		//所以非空判断需要自己添加
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
	}
	
}
