package com.example.pantry_pal.ui.home

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pantry_pal.R
import com.example.pantry_pal.databinding.FragmentHomeBinding

class HomeFragment: Fragment() , View.OnClickListener{

    private var _binding: FragmentHomeBinding? = null
    private lateinit var appleNews: ImageButton
    private lateinit var spiceNews: ImageButton
    private lateinit var eggNews: ImageButton
    private lateinit var coconutNews: ImageButton
    private lateinit var skittlesNews: ImageButton

    private lateinit var meal1: ImageButton
    private lateinit var meal2: ImageButton
    private lateinit var meal3: ImageButton
    private lateinit var meal4: ImageButton
    private lateinit var meal5: ImageButton

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {

        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        appleNews = root.findViewById(R.id.news_apple)
        spiceNews = root.findViewById(R.id.news_spice)
        eggNews = root.findViewById(R.id.news_egg)
        coconutNews = root.findViewById(R.id.news_coconut)
        skittlesNews = root.findViewById(R.id.news_skittles)
        meal1 = root.findViewById(R.id.meal1)
        meal2 = root.findViewById(R.id.meal2)
        meal3 = root.findViewById(R.id.meal3)
        meal4 = root.findViewById(R.id.meal4)
        meal5 = root.findViewById(R.id.meal5)

        appleNews.setOnClickListener(this)
        spiceNews.setOnClickListener(this)
        eggNews.setOnClickListener(this)
        coconutNews.setOnClickListener(this)
        skittlesNews.setOnClickListener(this)
        meal1.setOnClickListener(this)
        meal2.setOnClickListener(this)
        meal3.setOnClickListener(this)
        meal4.setOnClickListener(this)
        meal5.setOnClickListener(this)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        var url: String? = null
        when (v?.id) {
            R.id.news_apple -> {
                url = "https://www.bettycrocker.com/how-to/best-apples-to-bake-with"
                openLink(url)
            }

            R.id.news_spice -> {
                url =
                    "https://www.readersdigest.co.uk/food-drink/food-heroes/14-essential-spices-for-any-kitchen"
                openLink(url)
            }

            R.id.news_egg -> {
                url =
                    "https://www.eatright.org/health/wellness/nutrition-panels-and-food-labels/understanding-egg-labels"
                openLink(url)
            }

            R.id.news_coconut -> {
                url =
                    "https://www.brighamandwomensfaulkner.org/programs-and-services/nutrition/articles/coconut-oil"
                openLink(url)
            }

            R.id.news_skittles -> {
                url =
                    "https://www.npr.org/2022/07/22/1112929301/skittles-lawsuit-titanium-dioxide"
                openLink(url)
            }

            R.id.meal1 -> {
                url =
                    "https://www.tasteofhome.com/recipes/bean-burritos"
                openLink(url)
            }

            R.id.meal2 -> {
                url =
                    "https://www.tasteofhome.com/recipes/hawaiian-pork-chops/"
                openLink(url)
            }

            R.id.meal3 -> {
                url =
                    "https://www.tasteofhome.com/recipes/easy-pad-thai/"
                openLink(url)
            }

            R.id.meal4 -> {
                url =
                    "https://www.tasteofhome.com/recipes/nacho-pie/"
                openLink(url)
            }

            R.id.meal5 -> {
                url =
                    "https://www.tasteofhome.com/recipes/cajun-shrimp/"
                openLink(url)
            }



        }

    }

    fun openLink(url:String){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setPackage("com.android.chrome");
        try {
            startActivity(intent);
        } catch (e: ActivityNotFoundException) {
            // Chrome browser presumably not installed so allow user to choose instead
            intent.setPackage(null);
            startActivity(intent);
        }

        startActivity (intent)
    }
}