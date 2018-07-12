package com.cs.services.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.cs.dao.Class2Repository;
import com.cs.dao.CommodityRepository;
import com.cs.model.Class2;
import com.cs.model.Commodity;
import com.cs.services.ICommodityService;

@Service
@Transactional
public class CommodityServiceImpl implements ICommodityService {

	@Autowired
	private CommodityRepository commodityRepostory;
	@Autowired
	private Class2Repository class2Repository;

	@Override
	public List<Commodity> findAll() {
		return (List<Commodity>) commodityRepostory.findAll();
	}

	@Override
	public List<Commodity> findLastTen() {

		return commodityRepostory.findLastTen();
	}

	/**
	 * 根据二级分类分页查询商品
	 * 
	 * @param page
	 *            要查询第几页
	 * @param size
	 *            每页显示条数
	 * @param class2Id
	 *            二级分类id
	 * @return
	 */
	public Page<Commodity> pageByClass2Id(int page, int size, int class2Id) {
		Pageable pageable = PageRequest.of(page, size);
		Specification<Commodity> spc = new Specification<Commodity>() {
			private static final long serialVersionUID = 1L;
			@Override
			public Predicate toPredicate(Root<Commodity> root, CriteriaQuery<?> criteriaQuery,
					CriteriaBuilder criteriaBuilder) {

				return criteriaBuilder.equal(root.get("class2Id"), class2Id);
			}
		};
		return commodityRepostory.findAll(spc, pageable);
	}

	@Override
	public Commodity findByName(String commodityName) {

		return commodityRepostory.findByName(commodityName);
	}

	@Override
	public Commodity findByCommodityId(int id) {

		return commodityRepostory.findByCommodityId(id);
	}

	@Override
	public Page<Commodity> pageByClass1Id(int page, int size, int class1Id) {
		List<Class2> class2List = class2Repository.findByClass1Id(class1Id);
		int[] ids = new int[class2List.size()];
		Pageable pageable = PageRequest.of(page, size);
		Specification<Commodity> spc = new Specification<Commodity>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Commodity> root, CriteriaQuery<?> criteriaQuery,
					CriteriaBuilder criteriaBuilder) {

				for (int i = 0; i < class2List.size(); i++) {
					ids[i] = class2List.get(i).getClass2Id();
					criteriaQuery.where(criteriaBuilder.equal(root.get("class2Id"), ids[i]));
				}
				return null;
			}
		};
		return commodityRepostory.findAll(spc, pageable);

	}

	@Override
	public List<Commodity> findByClass1Id(int class1Id) {
		List<Class2> class2List = class2Repository.findByClass1Id(class1Id);
		int[] class2Id = new int[class2List.size()];
		for (int i = 0; i < class2List.size(); i++) {
			class2Id[i] = class2List.get(i).getClass2Id();
		}
		List<Commodity> commodityList = commodityRepostory.findByClass1Id(class2Id);
		return commodityList;
	}


}
