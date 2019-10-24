package com.gauravk.bubblebarsample.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.gauravk.bubblebarsample.R;

/**
 * A simple [Fragment] subclass.
 * Use the [ScreenSlidePageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
public class ScreenSlidePageFragment extends Fragment {

    private static final String ARG_TITLE = "arg_title";
    private static final String ARG_BG_COLOR = "arg_bg_color";

    private String title = "Default title.";
    private int bgColorResId = R.color.blue_inactive;

    private TextView tvScreenSlideTitle;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param title     Title parameter
     * @param bgColorId Background Color
     * @return A new instance of fragment ScreenSlidePageFragment.
     */
    public static ScreenSlidePageFragment newInstance(String title, int bgColorId) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE, title);
        bundle.putInt(ARG_BG_COLOR, bgColorId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        title = bundle.getString(ARG_TITLE);
        bgColorResId = bundle.getInt(ARG_BG_COLOR);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
        tvScreenSlideTitle = view.findViewById(R.id.screen_slide_title);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getView().setBackgroundColor(ContextCompat.getColor(getContext(), bgColorResId));
        tvScreenSlideTitle.setText(title);
    }
}
