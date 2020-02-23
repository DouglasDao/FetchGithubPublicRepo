package com.github.repo.model.response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class Owner(
    @SerializedName("gists_url")
    val gistsUrl: String?,
    @SerializedName("repos_url")
    val reposUrl: String?,
    @SerializedName("following_url")
    val followingUrl: String?,
    @SerializedName("starred_url")
    val starredUrl: String?,
    @SerializedName("login")
    val login: String?,
    @SerializedName("followers_url")
    val followersUrl: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("subscriptions_url")
    val subscriptionsUrl: String?,
    @SerializedName("received_events_url")
    val receivedEventsUrl: String?,
    @SerializedName("avatar_url")
    val avatarUrl: String?,
    @SerializedName("events_url")
    val eventsUrl: String?,
    @SerializedName("html_url")
    val htmlUrl: String?,
    @SerializedName("site_admin")
    val siteAdmin: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("gravatar_id")
    val gravatarId: String?,
    @SerializedName("node_id")
    val nodeId: String?,
    @SerializedName("organizations_url")
    val organizationsUrl: String?) : Parcelable {

    constructor(`in`: Parcel) : this(
        gistsUrl = `in`.readString(),
        reposUrl = `in`.readString(),
        followingUrl = `in`.readString(),
        starredUrl = `in`.readString(),
        login = `in`.readString(),
        followersUrl = `in`.readString(),
        type = `in`.readString(),
        url = `in`.readString(),
        subscriptionsUrl = `in`.readString(),
        receivedEventsUrl = `in`.readString(),
        avatarUrl = `in`.readString(),
        eventsUrl = `in`.readString(),
        htmlUrl = `in`.readString(),
        siteAdmin = `in`.readByte().toInt() != 0x00,
        id = `in`.readInt(),
        gravatarId = `in`.readString(),
        nodeId = `in`.readString(),
        organizationsUrl = `in`.readString()
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(gistsUrl)
        dest.writeString(reposUrl)
        dest.writeString(followingUrl)
        dest.writeString(starredUrl)
        dest.writeString(login)
        dest.writeString(followersUrl)
        dest.writeString(type)
        dest.writeString(url)
        dest.writeString(subscriptionsUrl)
        dest.writeString(receivedEventsUrl)
        dest.writeString(avatarUrl)
        dest.writeString(eventsUrl)
        dest.writeString(htmlUrl)
        dest.writeByte((if (siteAdmin) 0x01 else 0x00).toByte())
        dest.writeInt(id)
        dest.writeString(gravatarId)
        dest.writeString(nodeId)
        dest.writeString(organizationsUrl)
    }


    companion object CREATOR : Parcelable.Creator<Owner> {
        override fun createFromParcel(parcel: Parcel): Owner {
            return Owner(parcel)
        }

        override fun newArray(size: Int): Array<Owner?> {
            return arrayOfNulls(size)
        }
    }
}