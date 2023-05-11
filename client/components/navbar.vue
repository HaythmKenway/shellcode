<template>
	<div class=" flex min-w-[1150px] bg-gray-100 h-full">
		<div class="flex items-center bg-gray-900 h-[60px] py-2 fixed z-50 min-w-[1150px] w-full">
<div class="flex">
  <nuxt-link class="text-white h-[50px] p-2 pt-3 border-[1px] border-gray-900 rounded-sm hover:border-[1px] cursor-pointer">Shellcode</nuxt-link>
  </div>
  <div class="flex-col items-center justify-center">
	  <div class="text-[13px] text-gray-300 font-extrabold">
		  <div>Delivery to John
	  </div></div>
	  <div class="text-[12px] text-white -mt-1.5 font-extrabold">
		  <div><Icon name="material-symbols:location-on-outline"/>Tamilnadu</div></div>
  </div>

  <form class="ml-5 w-1/2">   
    <label for="default-search" class="mb-2 text-sm font-medium text-gray-900 sr-only dark:text-white">Search</label>
    <div class="relative">
        <div class="absolute inset-y-0 left-0 flex items-center pl-3 pointer-events-none">
            <svg aria-hidden="true" class="w-5 h-5 text-gray-500 dark:text-gray-400" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"></path></svg>
        </div>
        <input type="search" id="default-search" class="block w-full p-4 pl-10 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="Search for apis" required>
        <button type="submit" class="text-white absolute right-2.5 bottom-2.5 bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Search <Icon name="material-symbols:search-rounded"/></button>
    </div>
</form>
<nuxt-link link="/login"><Icon name="material-symbols:person-4-outline" class="border-[1px] text-white hover:bg-blue-800 mx-2 " height=2.5em width=2.5em /></nuxt-link>
</div> 
  
</div>	


</template>
