package pandy.test.service;

import org.hibernate.criterion.DetachedCriteria;

import pandy.test.domain.Customer;
import pandy.test.utils.PageBean;

public interface CustomerService {

	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

}
