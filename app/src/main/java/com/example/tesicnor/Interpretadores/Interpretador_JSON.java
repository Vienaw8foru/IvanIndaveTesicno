package com.example.tesicnor.Interpretadores;

import java.util.List;

public class Interpretador_JSON {


    public List<Search> Search;
    public String totalResults;
    public String Response;


    public class Search {
        public String Title  ;
        public String Year  ;
        public String imdbID  ;
        public String Type  ;
        public String Poster  ;

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public String getYear() {
            return Year;
        }

        public void setYear(String year) {
            Year = year;
        }

        public String getImdbID() {
            return imdbID;
        }

        public void setImdbID(String imdbID) {
            this.imdbID = imdbID;
        }

        public String getType() {
            return Type;
        }

        public void setType(String type) {
            Type = type;
        }

        public String getPoster() {
            return Poster;
        }

        public void setPoster(String poster) {
            Poster = poster;
        }
    }

    public List<Interpretador_JSON.Search> getSearch() {
        return Search;
    }

    public void setSearch(List<Interpretador_JSON.Search> search) {
        Search = search;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }
}
