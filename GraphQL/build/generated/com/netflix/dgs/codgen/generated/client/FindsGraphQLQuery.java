package com.netflix.dgs.codgen.generated.client;

import com.netflix.graphql.dgs.client.codegen.GraphQLQuery;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class FindsGraphQLQuery extends GraphQLQuery {
  public FindsGraphQLQuery(String titleFilter, Set<String> fieldsSet) {
    super("query");
    if (titleFilter != null || fieldsSet.contains("titleFilter")) {
        getInput().put("titleFilter", titleFilter);
    }
  }

  public FindsGraphQLQuery() {
    super("query");
  }

  @Override
  public String getOperationName() {
     return "finds";
                    
  }

  public static Builder newRequest() {
    return new Builder();
  }

  public static class Builder {
    private Set<String> fieldsSet = new HashSet<>();

    private String titleFilter;

    public FindsGraphQLQuery build() {
      return new FindsGraphQLQuery(titleFilter, fieldsSet);
               
    }

    public Builder titleFilter(String titleFilter) {
      this.titleFilter = titleFilter;
      this.fieldsSet.add("titleFilter");
      return this;
    }
  }
}
