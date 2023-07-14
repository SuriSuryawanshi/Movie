package com.suraj.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.suraj.movie.databinding.ActivityMainBinding
import com.suraj.movie.repository.MovieRepository
import com.suraj.movie.utills.MovieAdapter
import com.suraj.movie.viewmodel.MainViewModel
import com.suraj.movie.viewmodel.viewMainModelFactory
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject



class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var viewModelFactory: viewMainModelFactory

    lateinit var movieRV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(getLayoutInflater())
        setContentView(binding.root)

        (application as MovieApplication).appliationComponent.inject(this)

        mainViewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        movieRV = binding.movieRV;
        val layoutManager = GridLayoutManager(this, 2)
        movieRV.layoutManager = layoutManager
        val movieRVAdapter = MovieAdapter(this)
        movieRV.adapter = movieRVAdapter
        binding.progressCircular.visibility= View.VISIBLE

        binding.serachview.setOnQueryTextListener(object  :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                if (p0 != null) {
                    if (p0.length>0) {
                            binding.progressCircular.visibility= View.VISIBLE
                            mainViewModel.listenTosearch(p0.toString())

                    }
                }
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })

        mainViewModel.moviesLiveData.observe(this,{
            movieRVAdapter.updateList(it)
        })


        mainViewModel.showProgressBar().observe(this,{
            binding.progressCircular.visibility= View.GONE
        })
    }
}