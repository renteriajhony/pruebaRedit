package com.prueba.reddit.data.model.post

import com.google.gson.annotations.SerializedName

data class Cabecera (

    @SerializedName("kind") var kind : String,
    @SerializedName("data") var data : DataCabecera

)

data class DataCabecera (

    @SerializedName("modhash") var modhash : String,
    @SerializedName("dist") var dist : Int,
    @SerializedName("children") var children : List<Children>,
    @SerializedName("after") var after : String,
    @SerializedName("before") var before : String

)

data class Children (

    @SerializedName("kind") var kind : String,
    @SerializedName("data") var data : Post

)

data class Post (

    @SerializedName("approved_at_utc") var approvedAtUtc : String,
    @SerializedName("subreddit") var subreddit : String,
    @SerializedName("selftext") var selftext : String,
    @SerializedName("author_fullname") var authorFullname : String,
    @SerializedName("saved") var saved : Boolean,
    @SerializedName("mod_reason_title") var modReasonTitle : String,
    @SerializedName("gilded") var gilded : Int,
    @SerializedName("clicked") var clicked : Boolean,
    @SerializedName("title") var title : String,
 //   @SerializedName("link_flair_richtext") var linkFlairRichtext : List<String>,
    @SerializedName("subreddit_name_prefixed") var subredditNamePrefixed : String,
    @SerializedName("hidden") var hidden : Boolean,
    @SerializedName("pwls") var pwls : Int,
    @SerializedName("link_flair_css_class") var linkFlairCssClass : String,
    @SerializedName("downs") var downs : Int,
    @SerializedName("thumbnail_height") var thumbnailHeight : Int,
    @SerializedName("top_awarded_type") var topAwardedType : String,
    @SerializedName("hide_score") var hideScore : Boolean,
    @SerializedName("name") var name : String,
    @SerializedName("quarantine") var quarantine : Boolean,
    @SerializedName("link_flair_text_color") var linkFlairTextColor : String,
    @SerializedName("upvote_ratio") var upvoteRatio : Double,
    @SerializedName("author_flair_background_color") var authorFlairBackgroundColor : String,
    @SerializedName("subreddit_type") var subredditType : String,
    @SerializedName("ups") var ups : Int,
    @SerializedName("total_awards_received") var totalAwardsReceived : Int,
  //  @SerializedName("media_embed") var mediaEmbed : MediaEmbed,
    @SerializedName("thumbnail_width") var thumbnailWidth : Int,
    @SerializedName("author_flair_template_id") var authorFlairTemplateId : String,
    @SerializedName("is_original_content") var isOriginalContent : Boolean,
    @SerializedName("user_reports") var userReports : List<String>,
  //  @SerializedName("secure_media") var secureMedia : String,
    @SerializedName("is_reddit_media_domain") var isRedditMediaDomain : Boolean,
    @SerializedName("is_meta") var isMeta : Boolean,
    @SerializedName("category") var category : String,
  //  @SerializedName("secure_media_embed") var secureMediaEmbed : SecureMediaEmbed,
    @SerializedName("link_flair_text") var linkFlairText : String,
    @SerializedName("can_mod_post") var canModPost : Boolean,
    @SerializedName("score") var score : Int,
    @SerializedName("approved_by") var approvedBy : String,
    @SerializedName("author_premium") var authorPremium : Boolean,
    @SerializedName("thumbnail") var thumbnail : String,
    @SerializedName("edited") var edited : Boolean,
    @SerializedName("author_flair_css_class") var authorFlairCssClass : String,
  //  @SerializedName("author_flair_richtext") var authorFlairRichtext : List<String>,
  //  @SerializedName("gildings") var gildings : Gildings,
    @SerializedName("post_hint") var postHint : String,
 //   @SerializedName("content_categories") val contentCategories : String = "",
    @SerializedName("is_self") var isSelf : Boolean,
    @SerializedName("mod_note") var modNote : String,
    @SerializedName("created") var created : Int,
    @SerializedName("link_flair_type") var linkFlairType : String,
    @SerializedName("wls") var wls : Int,
    @SerializedName("removed_by_category") var removedByCategory : String,
    @SerializedName("banned_by") var bannedBy : String,
    @SerializedName("author_flair_type") var authorFlairType : String,
    @SerializedName("domain") var domain : String,
    @SerializedName("allow_live_comments") var allowLiveComments : Boolean,
    @SerializedName("selftext_html") var selftextHtml : String,
    @SerializedName("likes") var likes : String,
    @SerializedName("suggested_sort") var suggestedSort : String,
    @SerializedName("banned_at_utc") var bannedAtUtc : String,
    @SerializedName("url_overridden_by_dest") var urlOverriddenByDest : String,
    @SerializedName("view_count") var viewCount : String,
    @SerializedName("archived") var archived : Boolean,
    @SerializedName("no_follow") var noFollow : Boolean,
    @SerializedName("is_crosspostable") var isCrosspostable : Boolean,
    @SerializedName("pinned") var pinned : Boolean,
    @SerializedName("over_18") var over18 : Boolean,
 //   @SerializedName("preview") var preview : Preview,
    @SerializedName("all_awardings") var allAwardings : List<AllAwardings>,
    @SerializedName("awarders") var awarders : List<String>,
    @SerializedName("media_only") var mediaOnly : Boolean,
    @SerializedName("can_gild") var canGild : Boolean,
    @SerializedName("spoiler") var spoiler : Boolean,
    @SerializedName("locked") var locked : Boolean,
    @SerializedName("author_flair_text") var authorFlairText : String,
    @SerializedName("treatment_tags") var treatmentTags : List<String>,
    @SerializedName("visited") var visited : Boolean,
    @SerializedName("removed_by") var removedBy : String,
    @SerializedName("num_reports") var numReports : String,
    @SerializedName("distinguished") var distinguished : String,
    @SerializedName("subreddit_id") var subredditId : String,
    @SerializedName("mod_reason_by") var modReasonBy : String,
    @SerializedName("removal_reason") var removalReason : String,
    @SerializedName("link_flair_background_color") var linkFlairBackgroundColor : String,
    @SerializedName("id") var id : String,
    @SerializedName("is_robot_indexable") var isRobotIndexable : Boolean,
    @SerializedName("report_reasons") var reportReasons : String,
    @SerializedName("author") var author : String,
    @SerializedName("discussion_type") var discussionType : String,
    @SerializedName("num_comments") var numComments : Int,
    @SerializedName("send_replies") var sendReplies : Boolean,
    @SerializedName("whitelist_status") var whitelistStatus : String,
    @SerializedName("contest_mode") var contestMode : Boolean,
    @SerializedName("mod_reports") var modReports : List<String>,
    @SerializedName("author_patreon_flair") var authorPatreonFlair : Boolean,
    @SerializedName("author_flair_text_color") var authorFlairTextColor : String,
    @SerializedName("permalink") var permalink : String,
    @SerializedName("parent_whitelist_status") var parentWhitelistStatus : String,
    @SerializedName("stickied") var stickied : Boolean,
    @SerializedName("url") var url : String,
    @SerializedName("subreddit_subscribers") var subredditSubscribers : Int,
    @SerializedName("created_utc") var createdUtc : Int,
    @SerializedName("num_crossposts") var numCrossposts : Int,
  //  @SerializedName("media") var media : String = "",
    @SerializedName("is_video") var isVideo : Boolean

)

data class AllAwardings (

    @SerializedName("giver_coin_reward") var giverCoinReward : Int,
    @SerializedName("subreddit_id") var subredditId : String,
    @SerializedName("is_new") var isNew : Boolean,
    @SerializedName("days_of_drip_extension") var daysOfDripExtension : Int,
    @SerializedName("coin_price") var coinPrice : Int,
    @SerializedName("id") var id : String,
    @SerializedName("penny_donate") var pennyDonate : Int,
    @SerializedName("award_sub_type") var awardSubType : String,
    @SerializedName("coin_reward") var coinReward : Int,
    @SerializedName("icon_url") var iconUrl : String,
    @SerializedName("days_of_premium") var daysOfPremium : Int,
  //  @SerializedName("tiers_by_required_awardings") var tiersByRequiredAwardings : String,
    @SerializedName("resized_icons") var resizedIcons : List<ResizedIcons>,
    @SerializedName("icon_width") var iconWidth : Int,
    @SerializedName("static_icon_width") var staticIconWidth : Int,
    @SerializedName("start_date") var startDate : String,
    @SerializedName("is_enabled") var isEnabled : Boolean,
    @SerializedName("awardings_required_to_grant_benefits") var awardingsRequiredToGrantBenefits : String,
    @SerializedName("description") var description : String,
    @SerializedName("end_date") var endDate : String,
    @SerializedName("subreddit_coin_reward") var subredditCoinReward : Int,
    @SerializedName("count") var count : Int,
    @SerializedName("static_icon_height") var staticIconHeight : Int,
    @SerializedName("name") var name : String,
 //   @SerializedName("resized_static_icons") var resizedStaticIcons : List<ResizedStaticIcons>,
    @SerializedName("icon_format") var iconFormat : String,
    @SerializedName("icon_height") var iconHeight : Int,
    @SerializedName("penny_price") var pennyPrice : Int,
    @SerializedName("award_type") var awardType : String,
    @SerializedName("static_icon_url") var staticIconUrl : String

)

data class ResizedIcons (

    @SerializedName("url") var url : String,
    @SerializedName("width") var width : Int,
    @SerializedName("height") var height : Int

)