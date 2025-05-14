package com.rajkishorbgp.sign_up_sign_in.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.rajkishorbgp.sign_up_sign_in.model.Chat
import androidx.recyclerview.widget.RecyclerView
import com.rajkishorbgp.sign_up_sign_in.R
import com.rajkishorbgp.sign_up_sign_in.adapters.ChatsAdapter
import com.rajkishorbgp.sign_up_sign_in.data.ChatRepository
import com.rajkishorbgp.sign_up_sign_in.databinding.FragmentChatsBinding

class ChatsFragment : Fragment() {
    private var _binding: FragmentChatsBinding? = null
    private val binding get() = _binding!!
    private val chats = mutableListOf<Chat>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupMockData()
    }

    private fun setupMockData() {
        chats.clear()
        chats.addAll(ChatRepository.obtenerTodos(requireContext()))
        binding.rvChats.adapter = ChatsAdapter(chats) { chat ->
            val bundle = Bundle().apply { putString("nombreChat", chat.name) }
            findNavController().navigate(R.id.action_chatsFragment_to_chatDetailFragment, bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}