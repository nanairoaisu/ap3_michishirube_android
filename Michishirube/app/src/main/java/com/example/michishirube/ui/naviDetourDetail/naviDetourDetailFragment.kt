package com.example.michishirube.ui.naviDetourDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.michishirube.R
import kotlinx.android.synthetic.main.fragment_navi_detour_detail.view.*

class naviDetourDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //フラグメントで表示する画像をXMLファイルからインフレートする
        val view = inflater.inflate(R.layout.fragment_navi_detour_detail, container, false)
        //imDetourSpot(寄り道スポット画像)を取得
        val imDetourSpot = view.findViewById<ImageView>(R.id.imDetourSpot)
        //tvDetourSpot(寄り道スポット名)を取得
        val tvDetourSpot = view.findViewById<TextView>(R.id.tvDetourSpot)
        //tvDetourSpotDesc(寄り道スポット説明)を取得
        val tvDetourSpotDesc = view.findViewById<TextView>(R.id.tvDetourSpotDesc)

        //imDetourSpot(寄り道スポット画像)を更新
        imDetourSpot.setImageResource(R.drawable.`fun`)
        //tvDetourSpot(寄り道スポット名)を更新
        tvDetourSpot.text = "公立はこだて未来大学"
        //tvDetourSpot_desc(寄り道スポット説明)を更新
        val desc = "ガラス張りの2000年に建てられた大学。景色が反射して見えるため、季節や時刻によって、異なる見え方を楽しむことができる。"
        tvDetourSpotDesc.text = desc

        view.ibEvaluation.setOnClickListener {
            findNavController().navigate(R.id.action_naviDetourDetail_to_naviDetourEvaluation)
        }
        //インフレートされた画面を戻り値として返す
        return view
    }
}