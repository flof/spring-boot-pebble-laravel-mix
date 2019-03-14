package com.kuzoncby.mix.repository;

import com.kuzoncby.mix.model.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@Api(tags = "人员仓库", description = "人员实体")
@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    @ApiOperation(notes = "通过名称找人", value = "通过名称找人")
    List<Person> findByName(@Param("name") String name);

}
