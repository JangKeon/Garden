package com.example.garden.model;

import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class ContentDTO{
        @Nullable
        private String explain ;
        @Nullable
        private String imageUrl;
        @Nullable
        private String uid;
        @Nullable
        private String userId;
        @Nullable
        private Long timestamp;
        private int favoriteCount;
        @NotNull
        private Map favorites;


        @Nullable
        public final String getExplain() {
                return this.explain;
        }

        public final void setExplain(@Nullable String var1) {

                this.explain = var1;
        }

        @Nullable
        public final String getImageUrl() {
                return this.imageUrl;
        }

        public final void setImageUrl(@Nullable String var1) {
                this.imageUrl = var1;
        }

        @Nullable
        public final String getUid() {
                return this.uid;
        }

        public final void setUid(@Nullable String var1) {
                this.uid = var1;
        }

        @Nullable
        public final String getUserId() {
                return this.userId;
        }

        public final void setUserId(@Nullable String var1) {
                this.userId = var1;
        }

        @Nullable
        public final long getTimestamp() {
                return this.timestamp;
        }

        public final void setTimestamp(long var1) {
                this.timestamp = var1;
        }

        public final int getFavoriteCount() {
                return this.favoriteCount;
        }

        public final void setFavoriteCount(int var1) {
                this.favoriteCount = var1;
        }

        @NotNull
        public final Map getFavorites() {
                return this.favorites;
        }

        public final void setFavorites(@NotNull Map var1) {
                //Intrinsics.checkNotNullParameter(var1, "<set-?>");
                this.favorites = var1;
        }


}


