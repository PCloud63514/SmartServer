<script>
	import {onMount} from "svelte";
	let departments = []
	export let name;
	let departmentName;
	let description
	let a = 1;
	let b = 2;
	async function getDepartments() {
		let fetchData = []
		const result = await fetch("/department/list")
		const json = await result.json()
		fetchData.push(...json);
		departments = [...fetchData]
	}

	async function addDepartment() {
		const result = await fetch("http://localhost:8180/department",
				{
					method: "POST",
					headers: {
						"Content-Type": "application/json"
					},
					body: JSON.stringify({
						name: departmentName,
						description: description
					})
				})
	}

	onMount(async()=> {
		await getDepartments()
	})

</script>

<main>
	<h1>Hello {name}!</h1>
	<p>Visit the <a href="https://svelte.dev/tutorial">Svelte tutorial</a> to learn how to build Svelte apps.</p>

	<input type="text" placeholder="부서 명" bind:value={departmentName}>
	<input type="text" placeholder="부서 설명" bind:value={description}>


	<p>{departments}</p>
</main>

<style>
	main {
		text-align: center;
		padding: 1em;
		max-width: 240px;
		margin: 0 auto;
	}

	h1 {
		color: #ff3e00;
		text-transform: uppercase;
		font-size: 4em;
		font-weight: 100;
	}

	@media (min-width: 640px) {
		main {
			max-width: none;
		}
	}
</style>
