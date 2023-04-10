import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flixster_app.Movie
import com.example.flixster_app.OnListFragmentInteractionListener
import com.example.flixster_app.R

class MovieRecyclerViewAdapter(
    private val movies: List<Movie>,
    private val listener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var movie: Movie? = null
        val movieImage: ImageView = itemView.findViewById(R.id.posterImageView)
        val movieTitle: TextView = itemView.findViewById(R.id.titleTextView)
        val movieDescription: TextView = itemView.findViewById(R.id.descriptionTextView)

        override fun toString(): String {
            return movieTitle.toString() + " '" + movieDescription.text + "'"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]

        holder.movie = movie
        holder.movieTitle.text = movie.title
        holder.movieDescription.text = movie.description

        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w500/${movie.posterPath}")
            .placeholder(R.drawable.ic_launcher_background)
            .centerInside()
            .into(holder.movieImage)

        holder.itemView.setOnClickListener {
            holder.movie?.let { movie ->
                listener?.onItemClick(movie)
            }
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}
