package pizzaloop;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface PaymentRepository extends CrudRepository<PaymentDetails, Integer>{
    /*
     * Find pizza by Id
     */
    List<PaymentDetails> findByPaymentId(Integer id);

    /*
     * Delete pizza by Id
     */
    List<PaymentDetails> deleteByPaymentId(Integer id);
}
