package org.memo.app;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoRepository extends CrudRepository<Memo, Long>, PagingAndSortingRepository<Memo, Long> {

}
