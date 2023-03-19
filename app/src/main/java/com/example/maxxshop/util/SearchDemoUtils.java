package com.example.maxxshop.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.SearchView;

import com.example.maxxshop.R;

import java.util.ArrayList;
import java.util.List;

public class SearchDemoUtils {

    public static void setUpSuggestions(
            ViewGroup suggestionContainer, SearchView searchView) {
        addSuggestionTitleView(
                suggestionContainer, R.string.app_name);
        addSuggestionItemViews(suggestionContainer, getYesterdaySuggestions(), searchView);

        addSuggestionTitleView(
                suggestionContainer, R.string.app_name);
        addSuggestionItemViews(suggestionContainer, getThisWeekSuggestions(), searchView);
    }

    private static void addSuggestionTitleView(ViewGroup parent, @StringRes int titleResId) {
        TextView titleView =
                (TextView)
                        LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.cat_search_suggestion_title, parent, false);

        titleView.setText(titleResId);

        parent.addView(titleView);
    }

    private static void addSuggestionItemViews(
            ViewGroup parent,
            List<SuggestionItem> suggestionItems,
            SearchView searchView) {
        for (SuggestionItem suggestionItem : suggestionItems) {
            addSuggestionItemView(parent, suggestionItem, searchView);
        }
    }

    private static void addSuggestionItemView(
            ViewGroup parent, SuggestionItem suggestionItem, SearchView searchView) {
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.cat_search_suggestion_item, parent, false);

        ImageView iconView = view.findViewById(R.id.cat_searchbar_suggestion_icon);
        TextView titleView = view.findViewById(R.id.cat_searchbar_suggestion_title);
        TextView subtitleView = view.findViewById(R.id.cat_searchbar_suggestion_subtitle);

        iconView.setImageResource(suggestionItem.iconResId);
        titleView.setText(suggestionItem.title);
        subtitleView.setText(suggestionItem.subtitle);

        view.setOnClickListener(v -> submitSearchQuery(searchView, suggestionItem.title));

        parent.addView(view);
    }

    private static List<SuggestionItem> getYesterdaySuggestions() {
        List<SuggestionItem> suggestionItems = new ArrayList<>();
        suggestionItems.add(
                new SuggestionItem(
                        R.drawable.ic_search_api_freeme, "481 Van Brunt Street", "Brooklyn, NY"));
        suggestionItems.add(
                new SuggestionItem(
                        R.drawable.ic_search_api_freeme, "Home", "199 Pacific Street, Brooklyn, NY"));
        return suggestionItems;
    }

    private static List<SuggestionItem> getThisWeekSuggestions() {
        List<SuggestionItem> suggestionItems = new ArrayList<>();
        suggestionItems.add(
                new SuggestionItem(
                        R.drawable.ic_search_api_freeme,
                        "BEP GA",
                        "Forsyth Street, New York, NY"));
        suggestionItems.add(
                new SuggestionItem(
                        R.drawable.ic_search_api_freeme,
                        "Sushi Nakazawa",
                        "Commerce Street, New York, NY"));
        suggestionItems.add(
                new SuggestionItem(
                        R.drawable.ic_search_api_freeme,
                        "IFC Center",
                        "6th Avenue, New York, NY"));
        return suggestionItems;
    }

    private static void submitSearchQuery(SearchView searchView, String query) {
        searchView.setQuery(query, true);
    }

    private static class SuggestionItem {
        @DrawableRes
        private final int iconResId;
        private final String title;
        private final String subtitle;

        private SuggestionItem(int iconResId, String title, String subtitle) {
            this.iconResId = iconResId;
            this.title = title;
            this.subtitle = subtitle;
        }
    }
}
