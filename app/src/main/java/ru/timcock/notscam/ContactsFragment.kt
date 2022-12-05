package ru.timcock.notscam

import android.content.Intent
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import ru.timcock.notscam.databinding.FragmentContactsBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ContactsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ContactsFragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contacts, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentContactsBinding.bind(view)

        binding.telegramContact.setOnClickListener(this)
        binding.facebookContact.setOnClickListener(this)
        binding.instagramContact.setOnClickListener(this)
        binding.vkontakteContact.setOnClickListener(this)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ContactsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ContactsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.telegram_contact->{
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/Music_to_you_bot"))
                startActivity(intent)
            }
            R.id.facebook_contact->{
                Toast.makeText(activity,"facebook",Toast.LENGTH_SHORT).show()
            }
            R.id.instagram_contact->{
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/va_le_benkendorf/"))
                startActivity(intent)
            }
            R.id.vkontakte_contact->{
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/dima_gorbusha"))
                startActivity(intent)
            }

        }

    }
}