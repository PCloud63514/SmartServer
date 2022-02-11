
<script lang="ts">
	import SvelteTable from "svelte-table";
	import { Box } from "./components/atoms";
    import { CrossBox } from "./components/molecules";
    import {onMount} from "svelte"
	var departments = [{departmentName: "야!", description: "스벨트 소리!"}]
    let departmentName
    let description
	async function getDepartments() {
		const result = await fetch("http://localhost:8180/department/list")
		result.json().then((data)=> {
		    departments = data
        })
	}

	async function addDepartment() {
	    await fetch("http://localhost:8180/department", {
	        method: "POST",
            headers: {
	            "Content-Type": "application/json"
            },
            body: JSON.stringify({
                name: departmentName,
                description: description
            })
        }).then((data)=> {
            departmentName = null
            description = null
            getDepartments()
        })
    }

	onMount(async() => {
		await getDepartments()
	})
	// define some sample data...

	// define column configs
	const columns = [
        {
            key: "departmentId",
            title: "부서 아이디",
            value: v => v.departmentId
        },
		{
			key: "departmentName",
			title: "부서 명",
			value: v => v.departmentName
		},
		{
			key: "description",
			title: "description",
			value: v => v.description
		}
	];

</script>
<div class="header">
    <CrossBox></CrossBox>
</div>
<input type="text" placeholder="부서 명" bind:value={departmentName}>
<input type="text" placeholder="부서 설명" bind:value={description}>
<button on:click={addDepartment}>추가</button>
<SvelteTable columns="{columns}" rows="{departments}"></SvelteTable>


<style>
    .header {
        width: 500px;
        border: 1px solid #aaa;
    }
</style>
