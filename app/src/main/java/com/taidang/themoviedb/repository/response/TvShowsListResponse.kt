package com.taidang.themoviedb.repository.response

/**
 * Created by thuyhien on 5/7/18.
 */
class TvShowsListResponse (
    results: List<TvShowEntity>,
    total_results: Int,
    page: Int,
    total_pages: Int
) : ListBasedResponse<TvShowEntity>(results, total_results, page, total_pages)