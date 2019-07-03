package pizzaloop;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface OrderRepository extends CrudRepository<OrderDetails, Integer> {
    /*
     * Find pizza by Id
     */
    List<OrderDetails> findByOrderId(Integer id);

    /*
     * Delete pizza by Id
     */
    List<OrderDetails> deleteByOrderId(Integer id);
}
