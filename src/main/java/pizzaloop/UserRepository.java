package pizzaloop;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface UserRepository extends CrudRepository<UserDetails,Integer> {
    /*
     * Find pizza by Id
     */
    List<UserDetails> findByUserId(Integer id);

    /*
     * Delete pizza by Id
     */
    List<UserDetails> deleteByUserId(Integer id);
}
