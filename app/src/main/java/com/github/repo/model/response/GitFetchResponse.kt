package com.github.repo.model.response

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.databinding.BindingAdapter
import com.android.volley.toolbox.NetworkImageView
import com.github.repo.GithubRepoApplication
import com.google.gson.annotations.SerializedName

class GitFetchResponse(
    @SerializedName("tags_url")
    val tagsUrl: String?,
    @SerializedName("private")
    val jsonMemberPrivate: Boolean,
    @SerializedName("contributors_url")
    val contributorsUrl: String?,
    @SerializedName("notifications_url")
    val notificationsUrl: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("subscription_url")
    val subscriptionUrl: String?,
    @SerializedName("keys_url")
    val keysUrl: String?,
    @SerializedName("branches_url")
    val branchesUrl: String?,
    @SerializedName("deployments_url")
    val deploymentsUrl: String?,
    @SerializedName("issue_comment_url")
    val issueCommentUrl: String?,
    @SerializedName("labels_url")
    val labelsUrl: String?,
    @SerializedName("subscribers_url")
    val subscribersUrl: String?,
    @SerializedName("releases_url")
    val releasesUrl: String?,
    @SerializedName("comments_url")
    val commentsUrl: String?,
    @SerializedName("stargazers_url")
    val stargazersUrl: String?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("owner")
    val owner: Owner?,
    @SerializedName("archive_url")
    val archiveUrl: String?,
    @SerializedName("commits_url")
    val commitsUrl: String?,
    @SerializedName("git_refs_url")
    val gitRefsUrl: String?,
    @SerializedName("forks_url")
    val forksUrl: String?,
    @SerializedName("compare_url")
    val compareUrl: String?,
    @SerializedName("statuses_url")
    val statusesUrl: String?,
    @SerializedName("git_commits_url")
    val gitCommitsUrl: String?,
    @SerializedName("blobs_url")
    val blobsUrl: String?,
    @SerializedName("git_tags_url")
    val gitTagsUrl: String?,
    @SerializedName("merges_url")
    val mergesUrl: String?,
    @SerializedName("downloads_url")
    val downloadsUrl: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("contents_url")
    val contentsUrl: String?,
    @SerializedName("milestones_url")
    val milestonesUrl: String?,
    @SerializedName("teams_url")
    val teamsUrl: String?,
    @SerializedName("fork")
    val fork: Boolean,
    @SerializedName("issues_url")
    val issuesUrl: String?,
    @SerializedName("full_name")
    val fullName: String?,
    @SerializedName("events_url")
    val eventsUrl: String?,
    @SerializedName("issue_events_url")
    val issueEventsUrl: String?,
    @SerializedName("languages_url")
    val languagesUrl: String?,
    @SerializedName("html_url")
    val htmlUrl: String?,
    @SerializedName("collaborators_url")
    val collaboratorsUrl: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("pulls_url")
    val pullsUrl: String?,
    @SerializedName("hooks_url")
    val hooksUrl: String?,
    @SerializedName("assignees_url")
    val assigneesUrl: String?,
    @SerializedName("trees_url")
    val treesUrl: String?,
    @SerializedName("node_id")
    val nodeId: String?
) : Parcelable {


    constructor(`in`: Parcel) : this(
        tagsUrl = `in`.readString(),
        jsonMemberPrivate= `in`.readByte().toInt() != 0x00,
        contributorsUrl = `in`.readString(),
        notificationsUrl = `in`.readString(),
        description = `in`.readString(),
        subscriptionUrl = `in`.readString(),
        keysUrl = `in`.readString(),
        branchesUrl = `in`.readString(),
        deploymentsUrl = `in`.readString(),
        issueCommentUrl = `in`.readString(),
        labelsUrl = `in`.readString(),
        subscribersUrl = `in`.readString(),
        releasesUrl = `in`.readString(),
        commentsUrl = `in`.readString(),
        stargazersUrl = `in`.readString(),
        id = `in`.readInt(),
        owner = `in`.readValue(Owner::class.java.classLoader) as Owner?,
        archiveUrl = `in`.readString(),
        commitsUrl = `in`.readString(),
        gitRefsUrl = `in`.readString(),
        forksUrl = `in`.readString(),
        compareUrl = `in`.readString(),
        statusesUrl = `in`.readString(),
        gitCommitsUrl = `in`.readString(),
        blobsUrl = `in`.readString(),
        gitTagsUrl = `in`.readString(),
        mergesUrl = `in`.readString(),
        downloadsUrl = `in`.readString(),
        url = `in`.readString(),
        contentsUrl = `in`.readString(),
        milestonesUrl = `in`.readString(),
        teamsUrl = `in`.readString(),
        fork = `in`.readByte().toInt() != 0x00,
        issuesUrl = `in`.readString(),
        fullName = `in`.readString(),
        eventsUrl = `in`.readString(),
        issueEventsUrl = `in`.readString(),
        languagesUrl = `in`.readString(),
        htmlUrl = `in`.readString(),
        collaboratorsUrl = `in`.readString(),
        name = `in`.readString(),
        pullsUrl = `in`.readString(),
        hooksUrl = `in`.readString(),
        assigneesUrl = `in`.readString(),
        treesUrl = `in`.readString(),
        nodeId = `in`.readString()
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(tagsUrl)
        dest.writeByte((if (jsonMemberPrivate) 0x01 else 0x00).toByte())
        dest.writeString(contributorsUrl)
        dest.writeString(notificationsUrl)
        dest.writeString(description)
        dest.writeString(subscriptionUrl)
        dest.writeString(keysUrl)
        dest.writeString(branchesUrl)
        dest.writeString(deploymentsUrl)
        dest.writeString(issueCommentUrl)
        dest.writeString(labelsUrl)
        dest.writeString(subscribersUrl)
        dest.writeString(releasesUrl)
        dest.writeString(commentsUrl)
        dest.writeString(stargazersUrl)
        dest.writeInt(id)
        dest.writeValue(owner)
        dest.writeString(archiveUrl)
        dest.writeString(commitsUrl)
        dest.writeString(gitRefsUrl)
        dest.writeString(forksUrl)
        dest.writeString(compareUrl)
        dest.writeString(statusesUrl)
        dest.writeString(gitCommitsUrl)
        dest.writeString(blobsUrl)
        dest.writeString(gitTagsUrl)
        dest.writeString(mergesUrl)
        dest.writeString(downloadsUrl)
        dest.writeString(url)
        dest.writeString(contentsUrl)
        dest.writeString(milestonesUrl)
        dest.writeString(teamsUrl)
        dest.writeByte((if (fork) 0x01 else 0x00).toByte())
        dest.writeString(issuesUrl)
        dest.writeString(fullName)
        dest.writeString(eventsUrl)
        dest.writeString(issueEventsUrl)
        dest.writeString(languagesUrl)
        dest.writeString(htmlUrl)
        dest.writeString(collaboratorsUrl)
        dest.writeString(name)
        dest.writeString(pullsUrl)
        dest.writeString(hooksUrl)
        dest.writeString(assigneesUrl)
        dest.writeString(treesUrl)
        dest.writeString(nodeId)
    }

    companion object CREATOR : Parcelable.Creator<GitFetchResponse> {
        override fun createFromParcel(parcel: Parcel): GitFetchResponse {
            return GitFetchResponse(parcel)
        }

        override fun newArray(size: Int): Array<GitFetchResponse?> {
            return arrayOfNulls(size)
        }

        @JvmStatic
        @BindingAdapter("imageUrl")
        fun setImageUrl(imgView: NetworkImageView, url: String?) {
            imgView.setImageUrl(url, GithubRepoApplication.getInstance()?.getImageLoader())
        }

        var bundle:Bundle? =null
    }
}