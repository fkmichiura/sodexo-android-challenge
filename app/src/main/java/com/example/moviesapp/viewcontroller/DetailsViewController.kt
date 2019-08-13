package com.example.moviesapp.viewcontroller

import android.view.View
import android.widget.Toast
import com.example.moviesapp.MyApplication
import com.example.moviesapp.rest.Rest
import com.example.moviesapp.responses.Details
import com.example.moviesapp.responses.Images
import com.example.moviesapp.utils.Constants
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details.view.*
import kotlinx.android.synthetic.main.fragment_details.view.backdrop
import kotlinx.android.synthetic.main.fragment_details.view.poster

object DetailsViewController {

    private val activity = MyApplication.activity

    fun getMovieDetails(view: View, id: Int) {

        //Call trakt rest API getting details
        Rest.getDetails(id) { it ->

            //Response is successful
            if (it is Details) {
                //Populate xml with API data
                view.details_title.text = it.title
                view.details_year.text = it.year.toString()
                view.details_released.text = it.released
                view.details_overview.text = it.overview
                view.details_trailer.text = it.trailer
                view.details_homepage.text = it.homepage

                //Call TMDb rest API getting images
                Rest.getImages(it.ids.tmdb) {

                    if (it is Images) {

                        //Load images from TMDb API response
                        Picasso.get().load(Constants.IMG_BASE_URL + it.posterPath).into(view.poster)
                        Picasso.get().load(Constants.IMG_BASE_URL + it.backdropPath).into(view.backdrop)
                        return@getImages
                    }

                    //Response failed
                    Toast.makeText(
                        activity,
                        "Ocorreu um problema. Por favor, tente novamente",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                return@getDetails
            }

            //Response failed
            Toast.makeText(activity, "Ocorreu um problema. Por favor, tente novamente", Toast.LENGTH_SHORT).show()
        }
    }
}