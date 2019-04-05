package pandy.test.service.impl;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import pandy.test.dao.AccountDao;
import pandy.test.service.AccountService;

public class AccountServiceImpl implements AccountService{
	private AccountDao ad;
	private TransactionTemplate tt;
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void transfer(final Integer from,final Integer to,final Double money) {
		
		
	
				//减钱
				ad.decreaseMoney(from, money);
				int i =1/0;
				//加钱
				ad.increaseMoney(to, money);
			}
		/*public void transfer(final Integer from,final Integer to,final Double money) {
			
			
			tt.execute(new TransactionCallbackWithoutResult() {
				
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus arg0) {
					// TODO Auto-generated method stub
					//减钱
					ad.decreaseMoney(from, money);
					
					int i =1/0;
					//加钱
					ad.increaseMoney(to, money);
				}
			});
			
		*/
	
	public AccountDao getAd() {
		return ad;
	}
	public void setAd(AccountDao ad) {
		this.ad = ad;
	}
	public TransactionTemplate getTt() {
		return tt;
	}
	public void setTt(TransactionTemplate tt) {
		this.tt = tt;
	}
}
