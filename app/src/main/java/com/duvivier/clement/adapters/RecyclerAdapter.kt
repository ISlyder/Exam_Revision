
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.duvivier.clement.R
import com.duvivier.clement.model.Player

class RecyclerAdapter(private val liste : List<Player>, val context: Context, private val listener: (Player) -> Unit) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val nom : TextView = itemView.findViewById(R.id.tv_nom)
        val numero: TextView = itemView.findViewById(R.id.numero)
        val photo: ImageView = itemView.findViewById(R.id.img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context : Context = parent.context
        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.items_rv_menu, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.nom.text = liste[position].name
        holder.numero.text=liste[position].number.toString()
        Glide.with(context)
                .load(liste[position].photo)
                .into(holder.photo)
        holder.itemView.setOnClickListener{
            listener(liste[position])
        }
    }

    override fun getItemCount(): Int {
        return liste.size
    }
}
