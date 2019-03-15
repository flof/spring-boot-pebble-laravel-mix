package at.lingu.laravelmix.repository;

import at.lingu.laravelmix.model.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@Api(value = "Person Repository", tags = "Person Repository", description = "Repository to CRUD Person entity in H2 database")
@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    @ApiOperation(notes = "Find person by name", value = "Query database by name column")
    List<Person> findByName(@Param("name") String name);

}
