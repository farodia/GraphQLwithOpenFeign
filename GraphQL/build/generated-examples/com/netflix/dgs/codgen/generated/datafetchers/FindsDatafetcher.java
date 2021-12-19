package com.netflix.dgs.codgen.generated.datafetchers;

import com.netflix.dgs.codgen.generated.types.Book;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;

@DgsComponent
public class FindsDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "finds"
  )
  public List<Book> getFinds(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
