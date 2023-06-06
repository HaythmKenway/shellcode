<template>
	<div class="flex flex-col h-72 w-4/12 bg-gray-600 rounded m-1.5">
		<img class="h-3/6 w-full" v-bind:src="image"/>
		<h2 class="bg-inherit text-center text-white">{{title}}</h2>
		<p class="bg-inherit ">{{body}} </p><div class="bg-inherit">
			<button class="bg-blue-600 flex flex-row">Try now <img  class="bg-inherit" src="https://api.iconify.design/material-symbols:arrow-outward-rounded.svg?color=%23888888"/></button>
		<div class="bg-inherit flex justify-end p-6 ">
	<img class="bg-inherit" src="https://api.iconify.design/material-symbols:star-rate-rounded.svg?color=%23f6ff00" v-for="index in Number(rating)" :key="index" />
<img class="bg-inherit" src="https://api.iconify.design/material-symbols:star-outline-rounded.svg?color=%23f6ff00" v-for="index in 5 - Number(rating)" :key="index" />

	</div></div>
</div>
</template>
<style>
img{
  background-repeat: no-repeat;
}
</style>
<script>
export default{
	props:{
		title:String,
		body:String,
		image:String,
		rating:Number
	}
}
</script>

